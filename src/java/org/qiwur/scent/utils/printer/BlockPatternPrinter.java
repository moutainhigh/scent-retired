package org.qiwur.scent.utils.printer;

import java.util.Formatter;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.block.BlockPattern;
import org.jsoup.block.DomSegment;
import org.jsoup.nodes.Document;

public class BlockPatternPrinter {

	private static final Logger logger = LogManager.getLogger(BlockPatternPrinter.class);

  private final Document doc;
	private final Configuration conf;
	private StringBuilder reporter = new StringBuilder();

	public BlockPatternPrinter(Document doc, Configuration conf) {
		this.doc = doc;
		this.conf = conf;
	}

	public void process() {
    @SuppressWarnings("resource")
    Formatter formatter = new Formatter(reporter);

    logger.debug("all block patterns : {}", BlockPattern.patterns);
    int counter = 0;
    for (BlockPattern pattern : BlockPattern.patterns) {
      for (DomSegment segment : doc.domSegments().getAll(pattern)) {
        String parentName = "";
        if (segment.parent() != null) {
          parentName = segment.parent().block().prettyName();
        }

        ++counter;
        formatter.format("%-10s %-10s %-20s %-20s body:%-70s\n",
            StringUtils.substring(pattern.text(), 0, 10),
            segment.block().attr("data-blocking-rule"),
            StringUtils.substring(segment.block().prettyName(), 0, 20),
            StringUtils.substring(parentName, 0, 20),
            StringUtils.substring(segment.text(), 0, 70));
      }
    }

    logger.debug("\n{}\n total {} pattern tagged segments\n", reporter, counter);
	}
}
