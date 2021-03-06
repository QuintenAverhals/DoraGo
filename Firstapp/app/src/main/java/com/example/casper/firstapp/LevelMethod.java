package com.example.casper.firstapp;

public enum LevelMethod {
    dBFS, Max, SqrtRMS, dBFS_RMS,  RMS, LogRMS, Avg;

    public double[] getTicks(int levels) {

        //generate the raw pcm data
        double step = Short.MAX_VALUE/(double)levels;

        double[] retdata = new double[levels];

        for (int i=0; i<levels; i++) {
            short v = (short)((i+1)*step);
            retdata[i] = calculate(new short[]{v});

        }
        return retdata;
    }

    public double calculate(short[] data) {
        return calculate(data, data.length);
    }

    public double calculate(short[] data, int length) {
        return calculate(data, length, 1.0);
    }

    //http://dsp.stackexchange.com/questions/8785/how-to-compute-dbfs
    //https://www.dsprelated.com/showthread/comp.dsp/110229-1.php
    public double calculate(short[] data, int length, double scale) {
        double max = 0;
        double avg = 0;
        double rmssum = 0;
        for (int i=0; i<length; i++) {
            int dat = (int)(data[i] * scale);
            int abs;
            switch (this) {
                case RMS:
                case LogRMS:
                case SqrtRMS:
                case dBFS_RMS:
                    rmssum += dat*dat; break;
                case Avg:
                    avg += Math.abs(dat); break;
                case dBFS:
                case Max:
                    abs = Math.abs(dat);
                    if (abs > max) max = abs;

            }
        }

        //double rmsfactor = 1/.7;
        double rmsfactor = 1;
        double rmsavg;
        double resultval = 0;
        switch (this) {
            case Max:
                resultval = max; break;
            case Avg:
                resultval = avg/length; break;
            case dBFS_RMS:
                rmsavg = Math.sqrt(rmssum/length) * rmsfactor;
                resultval = 20*Math.log10(rmsavg/Short.MAX_VALUE);  break;
            case LogRMS:
                rmsavg = Math.sqrt(rmssum/length) * rmsfactor;
                resultval = Math.log(rmsavg); break;
            case SqrtRMS:
                rmsavg = Math.sqrt(rmssum/length) * rmsfactor;
                resultval = Math.sqrt(rmsavg); break;
            case RMS:
                rmsavg = Math.sqrt(rmssum/length) * rmsfactor;
                resultval = rmsavg; break;
            case dBFS:
                resultval = 20*Math.log10(max/Short.MAX_VALUE); break;

        }
        return resultval;
    }


}
