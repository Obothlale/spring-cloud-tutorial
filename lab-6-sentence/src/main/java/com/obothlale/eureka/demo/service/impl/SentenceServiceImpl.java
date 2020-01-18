package com.obothlale.eureka.demo.service.impl;

import com.obothlale.eureka.demo.client.*;
import com.obothlale.eureka.demo.service.SentenceService;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

    private SubjectClient subjectClient;
    private VerbClient verbClient;
    private ArticleClient articleClient;
    private AdjectiveClient adjectiveClient;
    private NounClient nounClient;

    public SentenceServiceImpl(SubjectClient subjectClient,
                               VerbClient verbClient,
                               ArticleClient articleClient,
                               AdjectiveClient adjectiveClient,
                               NounClient nounClient) {
        this.subjectClient = subjectClient;
        this.verbClient = verbClient;
        this.articleClient = articleClient;
        this.adjectiveClient = adjectiveClient;
        this.nounClient = nounClient;
    }

    @Override

    public String getSentence() {

        return subjectClient.getWord() + " " +
                verbClient.getWord() + " " +
                articleClient.getWord() + " " +
                adjectiveClient.getWord() + " " +
                nounClient.getWord();
    }


}
