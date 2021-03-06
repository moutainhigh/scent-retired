package org.qiwur.scent.segment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.block.BlockLabel;
import org.jsoup.block.DomSegment;
import org.jsoup.nodes.Document;

public abstract class BlockLocator {

	protected static final Logger logger = LogManager.getLogger(BlockLocator.class);

	protected Document doc = null;
	protected BlockLabel targetLabel = null;

	protected BlockLocator(Document doc, BlockLabel targetLabel) {
		this.doc = doc;
		this.targetLabel = targetLabel;
	}

  public DomSegment locate() {
    DomSegment segment = quickLocate();

    if (segment == null) {
      logger.warn("deep locate for {}", targetLabel);
      segment = deepLocate();
    }

    return segment;
  }

  protected abstract DomSegment quickLocate();

	protected abstract DomSegment deepLocate();

  public Document doc() {
    return doc;
  }

	public BlockLabel targetLabel() {
		return targetLabel;
	}
}
