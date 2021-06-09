package com.bridgeLabz.indiancensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CensusAnalyzerTest
{
    public static final String censusCsv="src\\test\\resources\\IndianCensus.csv";
    IndianCensusAnalyzer indianCensusAnalyzer=null;

    @BeforeEach
    void setUp()
    {
        indianCensusAnalyzer=new IndianCensusAnalyzer();
    }

    @Test
    public void givenCsvFile_WhenLoaded_ShouldTesturnTotalEntires() throws CustomeException {
        long entries=indianCensusAnalyzer.loadCensusData(censusCsv);
        Assertions.assertEquals(7,entries);
    }
}
