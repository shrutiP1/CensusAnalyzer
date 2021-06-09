package com.bridgeLabz.indiancensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IndianCensusAnalyzer {

    long numOfEntries = 0;

    public long loadCensusData(String censusCsv) throws CustomeException {
        try (Reader reader = Files.newBufferedReader(Paths.get(censusCsv));)
        {
            CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(IndianCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndianCensusCSV> censusCSVIterator=csvToBean.iterator();
            Iterable<IndianCensusCSV> csvIterable = () -> censusCSVIterator;
            numOfEntries = StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfEntries;

        } catch (IOException e) {
            throw new CustomeException(e.getMessage(), CustomeException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (IllegalStateException e) {
            throw new CustomeException(e.getMessage(), CustomeException.ExceptionType.UNABLE_TO_PARSE);

        }



    }

    public static void main(String[] args) {
        System.out.println("Welcome.");
    }
}
