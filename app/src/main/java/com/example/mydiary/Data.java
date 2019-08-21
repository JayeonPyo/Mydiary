package com.example.mydiary;

public class Data {

    private String key = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=451f608c5da2b0f5abd1cc0fc9a9cd2a";
    private String movieNum;
    private String directorNum;
    private String openStartDt;
    private String openEndDt;
    private String prdtStartYear;
    private String prdtEndYear;

    public Data(String movieNum, String directorNm, String openStartDt, String openEndDt, String prdtStartYear, String prdtEndYear) {
        this.movieNum = movieNum;

        this.directorNum = directorNm;
        this.openStartDt = openStartDt;
        this.openEndDt =  openEndDt;
        this.prdtStartYear = prdtStartYear;
        this.prdtEndYear = prdtEndYear;
    }

    public String getMovieNum() {
        return movieNum;
    }

    public String getDirectorNum() {
        return directorNum;
    }

    public String getOpenStartDt() {
        return openStartDt;
    }

    public String getOpenEndDt() {
        return openEndDt;
    }

    public String getPrdtStartYear() {
        return prdtStartYear;
    }

    public String getPrdtEndYear() {
        return prdtEndYear;
    }


}
