package com.bridgeLabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
public class IndianCensusAnalyzer
{
    public long loadCensusData(String censusCsv) throws CustomeException {
        try
        {
            long numOfEntries = 0;
            Reader reader= Files.newBufferedReader(Paths.get(censusCsv));
            CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder=new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusCSV> csvToBean=csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> censusCSVIterator=csvToBean.iterator();
            while(censusCSVIterator.hasNext())
            {
                numOfEntries++;
                IndianCensusCSV censusData=censusCSVIterator.next();
            }
            return numOfEntries;
        }
        catch (IOException e)
        {
            throw new CustomeException(e.getMessage(),CustomeException.ExceptionType.NO_EXTENSION_FOUND);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome.");

    }
}
