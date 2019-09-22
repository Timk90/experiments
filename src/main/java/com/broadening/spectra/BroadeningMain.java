package com.broadening.spectra;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Наложить уширение Лоренцева типа на
 * линейчатый колебательный спектр
 */
public class BroadeningMain implements Broadening {

    //Broadening factor
    private final static Double BROAD_FACTOR = 4d;
    //Starting frequency
    private final static int START_FREQ = 0;
    //Final frequency
    private final static int FINISH_FREQ = 4000;
    //Scaling factor
    private final static Double SCALE_FACTOR = 1d;

    private final static String IN_FILENAME = "spectra_xy.txt";
    private final static String OUT_FILENAME = "result_sp.txt";

    private BroadType broadType = BroadType.GAUSSIAN;
    private UnitsType unitsType = UnitsType.rcm;
    private int start;
    private int finish;
    private Double scaleFactor = SCALE_FACTOR;
    private Double broadeningFactor = BROAD_FACTOR;
    private SpectrumType spectrumType = SpectrumType.RAMAN;


    //содержит считанные данные или пересчитанные активности в интенсивности
    static Map<Double, Double> freqIntMap = new TreeMap<>();

    //содержит уширенный спектр
    static ArrayList<Double> list = new ArrayList<>();

    //Run set up initial setting
    {
        init();
    }

    /**
     * Чтение из файл с колонками X и Y
     */
    int readFromFile(String filename) {
        try {
            BufferedReader fr = new BufferedReader(new FileReader(new File(filename)));
            String line;
            while ((line = fr.readLine()) != null) {
                String[] splitedLine = line.split("\t");
                if (
                        splitedLine.length > 0 &&
                                !splitedLine[0].equals("") &&
                                !splitedLine[1].equals("") &&
                                !splitedLine[0].equals(null) &&
                                !splitedLine[1].equals(null)
                ) {
                    freqIntMap.put(Double.parseDouble(splitedLine[0]), Double.parseDouble(splitedLine[1]));
                }
                fr.close();
            }
        } catch (IOException e) {
            new IOException(this.getClass().getName(), e);
            return -1;
        } finally {
        }
        return 0;
    }

    /**
     * Пишем результаты в файл
     *
     * @param outputfile
     * @return 0 - если все считано успещно и -1, если возникло исключение
     */
    int writeToFile(String outputfile) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile));
            BufferedWriter bwX = new BufferedWriter(new FileWriter(outputfile + "_X"));
            BufferedWriter bwY = new BufferedWriter(new FileWriter(outputfile + "_Y"));
            for (int i = START_FREQ; i < FINISH_FREQ; i++) {
                bw.write(i * SCALE_FACTOR + "\t" + list.get(i) + "\n");
                bwX.write(i * SCALE_FACTOR + "\n");
                bwY.write(list.get(i) + "\n");
            }
            bw.close();
            bwX.close();
            bwY.close();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } finally {
        }
        return 0;
    }

    int writeToFile(){
        return writeToFile(OUT_FILENAME);
    }


    /**
     * Set up initial default settings
     */
    private void init() {
        setBroadeningType(BroadType.GAUSSIAN);
        setSpectralRange(START_FREQ, FINISH_FREQ);
        setUnits(UnitsType.rcm);
        setScaleFactor(SCALE_FACTOR);
        setBroadeningFactor(BROAD_FACTOR);
        setTypeOfSpectrum(SpectrumType.RAMAN);
    }

    @Override
    public List<Double> broadening() {

        if (spectrumType == SpectrumType.RAMAN) {
            convertActivitiesToIntensities(freqIntMap);
        }

        //заполнение списка нудевыми значениями интенсивностей
        for (int i = start; i < finish; i++) {
            list.add(0d);
        }

        for (Map.Entry<Double, Double> entry : freqIntMap.entrySet()) {
            Double peakPos = entry.getKey();
            Double peakInt = entry.getValue();

            for (int i = start; i < finish; i++) {
                Double nu = i * scaleFactor;
                Double sqrBroadFactor = Math.pow(broadeningFactor, 2);

                //Вычисление интенсивности для заданной частоты при наложении уширения
                Double intensity = peakInt * 4 * (sqrBroadFactor / (Math.pow((nu - peakPos), 2) + sqrBroadFactor));
                Double newIntensity = intensity + list.get(i);
                list.set(i, newIntensity);
            }
        }
        return list;
    }

    /**
     * конвертация КР активностей в интенсивности и перезапись в мапу
     * @param map
     * @return возвращает входную мапу с пересчитанными значениями активностей
     */
    private Map convertActivitiesToIntensities(Map<Double,Double> map){

        //Plank's constant
        final Double h = 6.6262 / Math.pow(10, 34);
        //Boltzmann constant
        final Double k = 1.3807 / Math.pow(10, 23);
        //speed of light
        final Double c = 3 * Math.pow(10, 10);
        //Room temperature in Kelvin
        final Double T = 300d;

        for (Map.Entry<Double, Double> entry : map.entrySet()) {
            Double peakInt = entry.getValue();

            //вичисляем интенсивность КР при заданной частоте возбуждающей линии (пересчет активностей на интенсивности)
            Double nu0 = Math.pow(10, 7) / 1064; //возбуждающая линия лазера = 1064 нм
            Double nu = entry.getKey();
            Double tmp = 1 - Math.exp((-h * c * nu) / (k * T));
            peakInt = peakInt * Math.pow((nu - nu0), 4) / (nu * tmp);
            //перезапись КР активности в интенсивность КР
            map.put(entry.getKey(), peakInt);
        }
        return map;
    }

    @Override
    public void setBroadeningType(BroadType type) {
        this.broadType = type;
    }

    @Override
    public void setSpectralRange(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void setUnits(UnitsType type) {
        this.unitsType = type;
    }

    @Override
    public void setScaleFactor(Double factor) {
        this.scaleFactor = factor;
    }

    @Override
    public void setBroadeningFactor(Double factor) {
        this.broadeningFactor = factor;
    }

    @Override
    public void setTypeOfSpectrum(SpectrumType type) {
        this.spectrumType = type;
    }

    @Override
    public String toString() {
        return "BroadeningMain{" +
                "broadType=" + broadType +
                ", unitsType=" + unitsType +
                ", start freq=" + start +
                ", finish freq=" + finish +
                ", scaleFactor=" + scaleFactor +
                '}';
    }

}
