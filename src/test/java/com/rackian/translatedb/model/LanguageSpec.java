package com.rackian.translatedb.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LanguageSpec {

    @Test
    public void whenAnyLanguageIsSelectedThenToStringWorksCorrectly() {
        assertThat(Language.EN.toString(), is("EN"));
        assertThat(Language.ES.toString(), is("ES"));
    }

}
