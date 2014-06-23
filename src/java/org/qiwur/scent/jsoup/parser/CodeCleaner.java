package org.qiwur.scent.jsoup.parser;

import org.qiwur.scent.jsoup.nodes.Attribute;
import org.qiwur.scent.jsoup.nodes.Element;
import org.qiwur.scent.jsoup.nodes.Indicator;
import org.qiwur.scent.jsoup.select.InterruptiveElementVisitor;
import org.qiwur.scent.utils.StringUtil;

public class CodeCleaner extends InterruptiveElementVisitor {

  @Override
  public void head(Element ele, int depth) {
    String _tag = ele.tagName();
    double _a = ele.indic(Indicator.A);
    double _img = ele.indic(Indicator.IMG);
    double _img_max_h = ele.indic(Indicator.IMH);
    double _img_max_w = ele.indic(Indicator.IMW);
    double _sep = ele.indic(Indicator.SEP);
    double _dep = ele.indic(Indicator.DEP);
    double _char = ele.indic(Indicator.CH);
    double _char_ave = ele.indic(Indicator.CHA);
    double _char_max = ele.indic(Indicator.CHM);
    double _txt_blk = ele.indic(Indicator.TB);
    double _own_txt_blk = ele.indic(Indicator.OTB);
    double _grand_child = ele.indic(Indicator.G);

    // can not remove in a traverse
    if (StringUtil.in(ele.tagName(), "object", "script", "style")) {
      ele.clearAttrs();
      ele.html("");
    }

    if (_own_txt_blk >= 3 && _grand_child == 0) {
      ele.html(ele.ownText());
      ele.addClass("mrg own txt");
    }

    if (depth > 3 && ele.classNames().isEmpty() && ele.isBlock()) {
      String cls = ele.parent().className();
      if (!cls.isEmpty()) {
        ele.addClass("in " + cls);
      }
    }

    for (Attribute attr : ele.attributes()) {
      if (attr.getKey().startsWith("on")) {
        ele.addClass("rm ev");
        attr.setValue("");
      }
    }
  }
}