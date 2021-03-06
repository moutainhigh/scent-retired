package org.qiwur.scent.data.feature;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qiwur.scent.utils.StringUtil;

import ruc.irm.similarity.FuzzyProbability;
import ruc.irm.similarity.sentence.editdistance.StandardEditDistance;
import ruc.irm.similarity.sentence.morphology.MorphoSimilarity;

import com.google.common.collect.Multiset;

public final class EntityNameFeature extends LinedFeature {

  static final Logger logger = LogManager.getLogger(EntityNameFeature.class);

  public static final int MinProductTitleSize = 6;

  public static final int MaxProductTitleSize = 100;

  // 移除括号中的内容，最小匹配
  public static final Pattern PAT_REMOVE_COMMENT_POTION = Pattern.compile("((（.+?）)|(【.+?】))");

  // visible inside the package
  public EntityNameFeature(Configuration conf, String[] featureFile) {
    super(conf, featureFile);
  }

  public static double getQuickSimilarity(String text, String text2) {
    Set<String> set = new HashSet<String>();
    set.add(text2);
    return getQuickMaxSimilarity(text, set);
  }

  // 由于相似度计算性能太差，所以使用一些加速的方法
  // 只要一个潜在标题是目标项的字串并且长度是目标项的70%，那么认为目标项是标题项
  public static double getQuickMaxSimilarity(final String text, Set<String> potentialTitles) {
    if (!validate(text)) return 0.0;

    double sim = 0.0;

    // 由于相似度计算性能太差，所以使用一些加速的方法
    // 只要一个潜在标题是目标项的字串并且长度是目标项的70%，那么认为目标项是标题项
    for (String potentialTitle : potentialTitles) {
      String text2 = StringUtil.stripNonChar(potentialTitle).toLowerCase();
      String text3 = StringUtil.stripNonChar(text).toLowerCase();

      if (text2.length() < text3.length()) {
        String tmp = text2;
        text2 = text3;
        text3 = tmp;
      }

      if (validate(text2) && text2.contains(text3)) {
        sim = text3.length() / (double) text2.length() + 0.15;

        if (FuzzyProbability.maybe(sim)) {
          // logger.debug("sim by length : {}, {} -|- {}", sim, text2, text3);
        }

        if (FuzzyProbability.veryLikely(sim)) {
          break;
        }
      }
    }

    // 计算标准编辑距离
    if (!FuzzyProbability.veryLikely(sim)) {
      for (String potentialTitle : potentialTitles) {
        String text2 = StringUtil.stripNonChar(potentialTitle).toLowerCase();
        String text3 = StringUtil.stripNonChar(text).toLowerCase();

        sim = getStandardEditSimilarity(text2, text3);

        if (FuzzyProbability.maybe(sim)) {
          // logger.debug("sim by standard edition : {}, {} -|- {}", sim, text2, text3);
        }

        if (FuzzyProbability.veryLikely(sim)) {
          break;
        }
      }
    }

    return sim;
  }

  public static double getStandardEditSimilarity(String text, String text2) {
    return new StandardEditDistance().getSimilarity(text, text2);
  }

  public static double getSimilarity(final String text, String text2) {
    Set<String> set = new HashSet<String>();
    set.add(text2);
    return getMaxSimilarity(text, set);
  }

  public static double getMaxSimilarity(final String text, Set<String> potentialTitles) {
    if (!validate(text)) return 0.0;

    double sim = getQuickMaxSimilarity(text, potentialTitles);

    // we find it
    if (FuzzyProbability.veryLikely(sim)) return sim;

    // use morpho similarity algorithm
    logger.debug("try semantic based lookup");

    for (String potentialTitle : potentialTitles) {
      if (!validate(potentialTitle) || !validate(text)) {
        continue;
      }

      String text2 = text;

      // 耗时子过程，原因是相似度计算效率太差，一个典型的句子（譬如商品标题）相似度计算需耗时半秒钟
      sim = MorphoSimilarity.getInstance().getSimilarity(potentialTitle, text2);

      if (FuzzyProbability.maybe(sim)) {
        logger.debug("similartiy : {}, protential : {}, header : {}", sim, potentialTitle, text2);
      }

      // 已经找到标题项
      if (FuzzyProbability.veryLikely(sim)) {
        break;
      }
    }

    return sim;
  }

  public static boolean validate(String name) {
    // 商品标题，至少10个字符，最多200个字符
    if (name == null || name.length() <= MinProductTitleSize || name.length() >= MaxProductTitleSize) {
      return false;
    }

    return true;
  }

  public Multiset<String> badWords() {
    return lines();
  }

  // 预处理
  public String strip(String name) {
    if (!validate(name))
      return "";

    // 去除黑名单中的词语
    for (String word : badWords()) {
      name = name.replace(word, "");
    }

    // 去除括号以及括号中的部分
    // name = PAT_REMOVE_COMMENT_POTION.matcher(name).replaceAll("");
    // 去除两端的空白
    name = StringUtil.trimNonChar(name, "[]()【】（）");

    if (!validate(name))
      return "";

    return name;
  }
}
