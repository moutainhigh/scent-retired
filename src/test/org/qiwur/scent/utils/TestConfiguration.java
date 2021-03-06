package org.qiwur.scent.utils;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

public class TestConfiguration {

  @Test
  public void testConf() throws IOException {
    Configuration conf = ScentConfiguration.create();
    String file = conf.get("scent.block.stat.feature.file");

    for (Entry<String, String> entry : conf) {
      if (entry.getKey().startsWith("scent")) {
        System.out.println(entry);
      }
    }

    for (String s : conf.getStrings("scent.classifier.block.labels")) {
      System.out.println(s);
    }
  }
}
