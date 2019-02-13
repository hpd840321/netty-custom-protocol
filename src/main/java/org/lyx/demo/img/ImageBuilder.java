package org.lyx.demo.img;

public class ImageBuilder {
    private String imgName;
    private String imgBody;

    public ImageBuilder() {
        imgBody= new StringBuffer().append("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCADIAJYDASIA\n" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD2Oo55\n" +
                "0toJJpDhEUsx9hUpGK8++K/iH+yPCl1bxSslxcL5a4ODzSKWp4d4+8SzeK/E9xdFybWE+XAo6AVy\n" +
                "rZqxL8sSgDHrxVUmg2WiAmm5oopEi04U7yiibmGKEG5gPWqASpYYyze1adjpL3JHysR7V1en6Bb2\n" +
                "0X2q4AKqM7cUXKsc/DZNHb8g5Yce9UbvSn8kyBcGu6hsWvZPtDR7V6KpGMU+501HjK7elTcLHlsf\n" +
                "ysVYYqRjitnWdMWGTzI1I9cViuuDTQrAH5pxIZeaip6HnnpTuB6f8JdcRpJtEuSNoBeEN39RXqUc\n" +
                "DwTl7dymO3avmmyu5dOv4L20kaOaJtwI7+1e2aR42i1G2ilkZYpWUBlPGTSE4s9Ah1SRRt8wbh1B\n" +
                "orlGvPPYSRuMkc4NFO5Gp6bNIIoy5PQV8z/FDXjrXieW2RyYbZznByC2P6V7d8QPEKeHvDFzcbgJ\n" +
                "WXbEPVq+YZmd3luJmJklcu5PqTmkXCJRnJPvVY1YkwxOOlRbaRTI6t2sIIMrDIHQVCseWq5LJ8gV\n" +
                "RtXHSmhJEFxIZW9McVd0XTmvrlVwOveqdrbtdXCx4OCeSO1d5oenxWSNKMhiOATSbsWkatlp0dqg\n" +
                "IwqoOpq2E+3usYQmIc9OtQI7XB2j7p7Vu2MQhhA796z5h2JoLOKOEKV6VXurRW+6MVe3DHWo3ORS\n" +
                "uScjrGmCQYHBI/OvPNVtJLO4ZGUgdie9eyTxBwcgGuK8XaO7232iHA2csuOSKqEhtHn9ANJnNFak\n" +
                "k8bHr6V1XhgWd+8ljcId4UsjKxFconStTQmI1uzRGCPJKsYY9Bk4zUsuL7nbf2LewH/Q9XuET+7K\n" +
                "N+PpRXa/8IfrRhR4BBcKe6Pg/jmipszS8Dlfi3rLavr8FkpYQ2oJYHgE9Pxrze6cJEynvxXReKrg\n" +
                "TeJLtRkiPEeT6jr+prl7w5wvbOaoxWwxU+TimbeatbcRrx2qPaQ9ADVXbyaQhnICjJ9Kn8l5cIg5").append("Naunad5d1+9z8oBGOmaTZVi5o2mMiruAyfvcV1MNrhRxVO2uYEdFYgDOBW3bukvCEGspNsoLeALz\n" +
                "itFWwKhACUm8VFwLAkp6nNVQwBpkl4sIJY9KLisXWXiqd1DE6MJFUqRyDWPd+LoY2aKC3eV1OCSc\n" +
                "CsyDUNT1G4PyMF3cKBx9KuIjiNc046bqksYH7pjuQ9iDWcDXdeLtKuPsUMzKGCnlh2rhGBViD1Fb\n" +
                "Ih6E8Y4zmp4naGeKZG2mNwwPpg1TU4NWQ2VI6gimB9Q+A9XF9pDyMTs3Dbn6UVx3wWvxd6bqFrIx\n" +
                "Z4pAR7LRQZtHkc07XE8tw5y8rl2+pNZl4ckDjrVx2IA3AA9Dis66OZAaRsywkpaNc9hipohvas+N\n" +
                "9orSsCguovMOELDNAI0hZyQ3AXbzs3g1sWdpJcQCSMgdj9aZdFJ9UsRb4z5ThzjqO1aenK4t5iiE\n" +
                "RbshiOvrWbZZUl0oTKN0pBHcCqsmn3NuyvBdvuB/vEYraQcjewA96c8VoeWlA7k7xUMRmW91qkDb\n" +
                "ZJzIue/NbtteFl+brWSzRg5R1K9jnrVmDJYYqWM02uOPrWbdStISM1bZCI84NZlxMsOWY4A9aSAS\n" +
                "CxMku9EBbua1I4p7UBsL68VhnxDHagEK3JAyOnNWm8SxSRq0DJOVXMgzjb+NXZiNK9uUuNOlhkUn\n" +
                "cpyD615ZqcHl3TEEkE9TXby6k86FljTB9CTXK6mFmc4wvO045wa0iyGYo61NGeQDURAVyuc4OMin\n" +
                "Iea0JO08B+Kh4R1y5uXG6G4tthXr8wYEH8s/nRXISRtKq7ckj+VFBLLcxwxqjcHLj6VcuuGNUZeT\n" +
                "SNpBGAWAPStK327wrIXXpgVlocGtnQ41ub9YGkKFxhGH97tQETrZvCGr6XZjVLOaG4Zo9xtnXnaf\n" +
                "Q96h0ZdT1jT1u7u9e0sWcrHFAoG7HXn0rutHkmudKWKUkyQkJk+nrWLpVsYtFNqV5trmVD+LE/1r\n" +
                "NlGLcyWlvIkMUE0iKQHkkbOPpWHrM8lrqJgtoRMjKGXAP412klqN3zID9aqvYw7w2wZFTdCOdgEk\n" +
                "jokke0Y7DGK055rjRIVuUtzdRO4jC7sEMenatKGxjDb89O1QagHn8m1TK7pVbce2OaQErXOvSW5P\n" +
                "2GxhYfwNMS1Y8fnaiss08YieNzGYgSQGHWupTRFTT5Lp52Mxbd83IC1ztsWtr2ZOCsjFwaLAZt1o\n" +
                "bXSAPK0fOcKM1Ppmiy2tvNbqxMcpyWZeTxW0TuPSpomKkU+boFiC20lYodoXgVyl1p4TW9UgHKpI\n" +
                "jDB/vD/69ehQyHGD0rmGtyNd1O5K/u5JEx9EHWriyJI87lGyd1HQMRSo2DTJX8yZ3/vMTSCtDFM0\n" +
                "oMFOTRVWKTHU0UzSxdvPvVQfrWjeDk1mv1qUXIbnmtLSJDDqVpNnG2QVl55rWtFjuII9q4aH5mIP\n" +
                "J5pMmD1PbdGIWNjgYcA1DdRpZ6pNJwLe5wTjs9RaHcedp0Eh4LoCfatC5AkXDYIPUHvWLZsjFu87\n" +
                "vlOR7VRIJNXLmzkVwY5nVewHaqbwyo3MpI+gqWFhRgDLEAe9RJD9ou1k/hH3aikBknSIZYkgD61t\n" +
                "wae8B+b+Hk5ouOxowANbFD0xgiuW1W0VJzj5ccq1bTXJjOAT+FQyi3uh5cjx7m/h3Dd+VO4rGPA6\n" +
                "yD5mCkdqtKIgeZUz9aoxRGGeWIsSFY4Jq+kfHSkImSVB8qqxPr2rK1V/I0y9kBO4ROR9cGtULhQK\n" +
                "57xTL5GjXBzjeAv5mtI7kSWh5tThTaUVscyJUooWimbGxOu7JrImGHIrYmbg1k3H3zSHIrk06OV4\n" +
                "z8jFc9cHFNPWkFBhezPaPBd4t1oFuS25lG1j3yOtdE4JryfwJrn2G++xTMBFM3yk9m9Pxr1iN/Mj\n" +
                "BrnmrM7IO6uQvFuFZtzCc1sMOKqyJnNRcsw/sxikWUdVOQcVS1WW/v7mN2vJURORGnC5ronhDDpV\n" +
                "SaxBOeg75ouMxn1O5ZCjxp5mMb1z/Kq8OgzyXS3QbZISCzE4/KthrW3RwTJyOcVbjvbVztWZcgUy\n" +
                "QOnx4yMlvWmiApVgzKpA3rz0560Bwx65pMRCy4WuF8c3qgR2gzuJ3H2xXezsiRM7HCqMmvHNavzq").append("eqzXHRC2EGeg7VrSRlUlZGfTh1pMU4VsYJEiUUgNFM2NSRsqazZgdxq8TxVaQAmpQ2UyMUlSOADU\n" +
                "dUc7VmPR2R1dSQynII7V6n4M8UrqFuLO6kUXSDAJ/wCWg/xrympYZpIJVlico6nKsDyKiUbo0hPl\n" +
                "PoQNkVXnfaM1yfhnxlDqEC2166x3Sjgno/8A9eumaQOBzkHpXM04s6k7q6Mi+8Qy2M/lR2Lz56no\n" +
                "BWBf67r+oO629mscJ4IVucfXIrsvKjIO5QfqKglsrbZwNn+7TTRSOJit/EBVhGSmeCZJAf8AIp40\n" +
                "TWJQBLqcUYYYOxecfkK6VlRW4JOO9IsceS2ctVXsDRlWfh6KJ0llu7iWRORuPBNb0LeWuM1GAWxg\n" +
                "cCsfXtbh0i2ddwa5Yfu0/qan4noZydin4013yLcafA/72QZkIP3V9Pxrz+nzzyXM7zSuXdzkk1HX\n" +
                "TGNlY5pS5mKKWiimCFooFFIq5oGq8hpfMLGmSHimW2QOeaZSt1pKZzvcKM0UUCHo5RgykgjoRXT6\n" +
                "N4xvLFkiuD58OQDvJyBXLCnCplFPc0hJo9s03VLPVYQ9pMrkfeXPIP0qxPDuSvFbK8ltLhJIpGQg\n" +
                "g5U4rv8AS/FtxIgimCT9g/Q/jXPKHKdMJXNp4QCaEjUHnrVcagZkB2BTTJbghThuagpsbrWsRaTZ\n" +
                "F1KvOeETP868tu7qa8uXnncvIxySTXQ6/KJiW9M4rmD1ropI56rClApBThWjMohRS0lIsKKSimSS\n" +
                "A0jHigUjUFt6CKhY4FKYiBntWvpmns8QdkOG9u1XX0xVXaBx3piUVY5raaNtbE+mkHKjiqE0Bj7U\n" +
                "BylZgAOKSnGmUiWKDV/T7swTDJ4qhSqcUmroqMrM9Espg8QOakuJQE9qwdCuHljYFuAenpWvMdyY\n" +
                "7VytWZu2czqzgtgd6wm61rak4e6ZE5CcEj1rKYYNdEFZGNQQU4U2nCrZERaKKWgsMUUuaKdgJPId\n" +
                "Uywx9an062S7uxExOMdRWxc6VLOdqYAHUkVa0jSBBqtqrDcWfBoGdFbaZstkAAwBgGoZrH6105s/\n" +
                "KhCqMKKja1DLgjmkK5yMljx0rPudOWQYK/jXZzab8pyxJqt/Z+5cbOKQ0zzq80p4wXjGQOorKZCD\n" +
                "yMV6lPpKFCNnB7Vy2o+HGdHkhYhh0U9DTE0mcnSinSxvFIyOpVh1BplBmamkXMltckoAQ42nNbwl\n" +
                "nc/eAGKwdKgM0vsBmuiCgKuBWbV2bJ6GdNZoAxUfOep9axbqAoxOMV1hh3HODVC+sQTuXqR0NVEl\n" +
                "u5y9OFWTZud+VIIOBUa2s0jYSNmPoBmqJ5bEVOAycVai0m/lbC27Y9T0rqNN8HxPb5uppN57x8Yo\n" +
                "GjmYrB5F3bh9KK9Dh8Fw7Mm+nYdAMAEUUXKJfs3tTXgFpcW1yQcJIGOB2raittzUXtkHg6dOlSK5\n" +
                "qxss6KynKsMgipPswrlLe8vNPysDgrn7jjityz15Z9q3EPlSHjKnIJ/pTFYvtaBhjFAs1HUVZikR\n" +
                "+jKfoaeaQmZ0tmrKRjtxWVcaaqqfl59a6QgGoXjDcEZpjPNvEnh9bjT5J4Iv36fNn1A615/DE0jY\n" +
                "Ar36a0Uoy7cgjFeaX+hppWtTKEzHId8fHTNO4mUtMs2t4wz/AHiO1aMa7sCnrHngdKs29vht3WoC\n" +
                "4ix5GMcCoZ4QOvWtPbheRVW5QsvFMVzHltwV6cmmWEW3UVT5fmX1q48ZHWoISseowPzuLhR+PFMt\n" +
                "HU2tmvHatWGAAgmobZcY4JFX0HtSuJkqoCuDzRT1BxRQMW3gKg8VLJEGUgiiigkyLiy2sSF4qsYd\n" +
                "p6UUUDLumaVcTzC5VxHGD1JPzVuqGUYPOKKKBDwpNKEoooAPLya5/wAY6WZtHN3BEGnt2DZHXZ3o\n" +
                "ooEcda/vNrD7prRMQVQQeaKKBEgUNxUUsSopPrRRTAz3jYkjFUJoSk8b9lYHp70UUjRHdWQLRKx7\n" +
                "gEfStFY8dqKKGJj1BAooooFc/9k=").toString();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgBody() {
        return imgBody;
    }

    public void setImgBody(String imgBody) {
        this.imgBody = imgBody;
    }
}
