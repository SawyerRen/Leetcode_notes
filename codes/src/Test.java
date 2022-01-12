import java.text.NumberFormat;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {
    static void solution(long n) {
        double[] nodes = {
                41023461,
                85734516,
                117281328,
                125736242,
                141878141,
                165308929,
                185920185,
                221671914,
                227453371,
                340980054,
                357445747,
                375597852,
                453005073,
                484408336,
                487574807,
                623671120,
                692704175,
                697323074,
                764379973,
                789296165,
                803152581,
                916542415,
                931833455,
                952627244,
                994063877,
                1063543501,
                1095619456,
                1098796346,
                1111608456,
                1120746458,
                1151137969,
                1181992062,
                1187165134,
                1252080068,
                1261294919,
                1296716671,
                1316531642,
                1318382642,
                1341912145,
                1381160637,
                1404663120,
                1422888474,
                1546942430,
                1560975388,
                1574796670,
                1585416285,
                1612579555,
                1656924640,
                1724755455,
                1731889169,
                1754318746,
                1762436030,
                1764222159,
                1775858108,
                1800372655,
                1809291066,
                1863256569,
                1891506992,
                1942391358,
                1953369586,
                1968770578,
                2025363743,
                2027722572,
                2031829201,
                2164747594L,
                2172985745L,
                2192856140L,
                2273480401L,
                2284205690L,
                2316135367L,
                2323499285L,
                2341081299L,
                2398120550L,
                2410249898L,
                2421703563L,
                2533231366L,
                2588113728L,
                2609076330L,
                2659741832L,
                2661558850L,
                2666144559L,
                2666469865L,
                2679467071L,
                2710439878L,
                2718627103L,
                2745687488L,
                2786462292L,
                2819986368L,
                2900791414L,
                2962760732L,
                2997760308L,
                3021167971L,
                3082456979L,
                3108575688L,
                3120899843L,
                3121824464L,
                3160801474L,
                3171558423L,
                3204538100L,
                3358105298L,
                3427287623L,
                3435223392L,
                3455481312L,
                3500380522L,
                3520503822L,
                3549309559L,
                3577574332L,
                3599771466L,
                3624420161L,
                3675748542L,
                3696728729L,
                3706957430L,
                3745581151L,
                3747460195L,
                3796694723L,
                3804850610L,
                3850900472L,
                3906413794L,
                3968044193L,
                3993839047L,
                4024184364L,
                4056579626L,
                4074051712L,
                4092914857L,
                4127129221L,
                4131133786L,
                4248431269L,
                4276933077L
        };
        TreeSet<Double> set = new TreeSet<>();
        for (double node : nodes) {
            set.add(node);
        }
        double start = n;
        Double dest = set.ceiling(305419896.0);
    }

    public static void main(String[] args) {
        double[] nodes = {
                41023461,
                85734516,
                117281328,
                125736242,
                141878141,
                165308929,
                185920185,
                221671914,
                227453371,
                340980054,
                357445747,
                375597852,
                453005073,
                484408336,
                487574807,
                623671120,
                692704175,
                697323074,
                764379973,
                789296165,
                803152581,
                916542415,
                931833455,
                952627244,
                994063877,
                1063543501,
                1095619456,
                1098796346,
                1111608456,
                1120746458,
                1151137969,
                1181992062,
                1187165134,
                1252080068,
                1261294919,
                1296716671,
                1316531642,
                1318382642,
                1341912145,
                1381160637,
                1404663120,
                1422888474,
                1546942430,
                1560975388,
                1574796670,
                1585416285,
                1612579555,
                1656924640,
                1724755455,
                1731889169,
                1754318746,
                1762436030,
                1764222159,
                1775858108,
                1800372655,
                1809291066,
                1863256569,
                1891506992,
                1942391358,
                1953369586,
                1968770578,
                2025363743,
                2027722572,
                2031829201,
                2164747594L,
                2172985745L,
                2192856140L,
                2273480401L,
                2284205690L,
                2316135367L,
                2323499285L,
                2341081299L,
                2398120550L,
                2410249898L,
                2421703563L,
                2533231366L,
                2588113728L,
                2609076330L,
                2659741832L,
                2661558850L,
                2666144559L,
                2666469865L,
                2679467071L,
                2710439878L,
                2718627103L,
                2745687488L,
                2786462292L,
                2819986368L,
                2900791414L,
                2962760732L,
                2997760308L,
                3021167971L,
                3082456979L,
                3108575688L,
                3120899843L,
                3121824464L,
                3160801474L,
                3171558423L,
                3204538100L,
                3358105298L,
                3427287623L,
                3435223392L,
                3455481312L,
                3500380522L,
                3520503822L,
                3549309559L,
                3577574332L,
                3599771466L,
                3624420161L,
                3675748542L,
                3696728729L,
                3706957430L,
                3745581151L,
                3747460195L,
                3796694723L,
                3804850610L,
                3850900472L,
                3906413794L,
                3968044193L,
                3993839047L,
                4024184364L,
                4056579626L,
                4074051712L,
                4092914857L,
                4127129221L,
                4131133786L,
                4248431269L,
                4276933077L
        };
        TreeSet<Double> set = new TreeSet<>();
        for (double node : nodes) {
            set.add(node);
        }
        System.out.println(set.ceiling((double) (306419896 + 3500380522L)));
        System.out.println(set.ceiling((double) 306419896));
    }
}
