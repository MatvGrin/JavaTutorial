package org.configuring_dependency_injection_through_a_field;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration {
    private String lyric = "I саn keep the door " + "cracked open, to let light through";

    public Inspiration(@Value("For all my running, I саn uпderstaпd") String lyric) {
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }
}
