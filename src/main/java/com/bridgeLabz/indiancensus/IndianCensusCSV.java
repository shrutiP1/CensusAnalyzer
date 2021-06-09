package com.bridgeLabz.indiancensus;

import com.opencsv.bean.CsvBindByName;

public class IndianCensusCSV
{
    @CsvBindByName(column="state" ,required = true)
    public String state;

    @CsvBindByName(column="population",required = true)
    public int population;

    @CsvBindByName(column="AreaPerSqKm",required = true)
    public int AreaPerSqKm;

    @CsvBindByName(column = "DistancePerSqKm",required = true)
    public int DistancePerSqKm;

}
