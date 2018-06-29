package kr.leocat.test.sample.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class MarkerFilterSample {

    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("MESSAGE");
    private static final Logger log = LoggerFactory.getLogger(MarkerFilterSample.class);

    public static void main(String [] args) {

        log.debug("ABCD");
        log.debug(MESSAGE_MARKER, "EFGH");
        log.debug("IJKL");

    }

}
