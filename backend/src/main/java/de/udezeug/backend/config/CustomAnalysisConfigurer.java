package de.udezeug.backend.config;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class CustomAnalysisConfigurer implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer("german").custom()
                .tokenizer("standard")
                .tokenFilter("lowercase")
                .tokenFilter("snowballPorter")
                .param("language", "German");

        context.analyzer("autocomplete").custom()
                .tokenizer("standard")
                .tokenFilter("lowercase")
                .tokenFilter("edgeNGram")
                .param("minGramSize", "2")
                .param("maxGramSize", "10");

        context.analyzer("autocomplete_query").custom()
                .tokenizer("standard")
                .tokenFilter("lowercase");
    }
}
