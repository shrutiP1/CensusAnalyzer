package com.bridgeLabz.indiancensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CensusAnalyzerTest
{
    public static final String censusCsv="src\\test\\resources\\IndianCensus.csv";
    public static final String wrong_csv_path="src\\test\\resorces\\Census";
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
    @Test
    public void givenWrongFile_shouldGiveException() throws CustomeException {
        try
        {
            indianCensusAnalyzer.loadCensusData(wrong_csv_path);
        }
        catch(CustomeException e)
        {
            System.out.println(e.exceptionType);
            Assertions.assertEquals(CustomeException.ExceptionType.CENSUS_FILE_PROBLEM,e.exceptionType);
        }

    }

    

}
