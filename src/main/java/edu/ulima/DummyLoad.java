package edu.ulima;

import edu.ulima.entidad.Country;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.Course;
import edu.ulima.entidad.TeacherType;
import edu.ulima.entidad.Period;
import edu.ulima.entidad.Section;
import edu.ulima.persistencia.CareerRepositorio;
import edu.ulima.persistencia.CountriesRepositorio;
import edu.ulima.persistencia.CourseRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.PeriodRepositorio;
import edu.ulima.persistencia.SectionRepositorio;
import edu.ulima.persistencia.TeacherTypeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
/*import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Component;

@Component
public class DummyLoad implements CommandLineRunner {

    @Autowired
    //private UsuarioRepositorio repoU;
    private GenderRepositorio repoG;
    
    @Autowired
    private CareerRepositorio repoCa;
    
    @Autowired
    private CourseRepositorio repoCou;
    
    @Autowired
    private TeacherTypeRepositorio repoTeType;
    
    @Autowired
    private PeriodRepositorio repoP;
    
    @Autowired
    private SectionRepositorio repoS;
    
    @Autowired
    private CountriesRepositorio repoCoun;
    
    /*@Autowired
    private PasswordEncoder pwEncoder;*/
    
    @Override
    public void run(String... args) throws Exception {
        // Aqui se ejecuta la logica principal
        // INSERT - save
        // DELETE - remove
        // UPDATE  - merge
        // SELECT find - select
        /*
        repoU.save(new UserStudent(1, first, firstS.getId(), "20171871", pwEncoder.encode("password"), "1234", "1234"));
    */    
        //GENDER
        repoG.save(new Gender(1, "FEMENINO"));
        repoG.save(new Gender(2, "MASCULINO"));
        //CAREER
        Career c1 = repoCa.save(new Career(1, "ESTUDIOS GENERALES"));
        Career c2 = repoCa.save(new Career(2, "ADMINISTRACION"));
        Career c3 = repoCa.save(new Career(3, "ECONOMIA"));
        Career c4 = repoCa.save(new Career(4, "DERECHO"));
        Career c5 = repoCa.save(new Career(5, "INGENIERIA"));
        //COURSE
        Course cou1 = repoCou.save(new Course(1, 101, "MATEMATICAS", c1));
        Course cou2 = repoCou.save(new Course(2, 102, "HISTORIA", c2));
        Course cou3 = repoCou.save(new Course(3, 103, "PSICOLOGIA", c3));
        //COUNTRIES
        Country coun1 = repoCoun.save(new Country(1, "Peru"));
        Country coun2 = repoCoun.save(new Country(2, "Argentina"));
        //TEACHERTYPE
        TeacherType te1 = repoTeType.save(new TeacherType(1, "PROFESOR"));
        TeacherType te2 = repoTeType.save(new TeacherType(2, "JEFE DE PRACTICAS"));
        //PERIOD
        Period p1 = repoP.save(new Period(1, "2020-0", 2020));
        Period p2 = repoP.save(new Period(2, "2020-1", 2020));
        //SECTION
        Section s1 = repoS.save(new Section(1, 10101, cou1, p2));
        Section s2 = repoS.save(new Section(2,10102,cou1,p2));
        Section s3 = repoS.save(new Section(3,10103,cou1,p2));
        Section s4 = repoS.save(new Section(4,10104,cou1,p2));
        Section s5 = repoS.save(new Section(5,10105,cou1,p2));
        Section s6 = repoS.save(new Section(6,10106,cou1,p2));
        Section s7 = repoS.save(new Section(7,10107,cou1,p2));
        Section s8 = repoS.save(new Section(8,10108,cou1,p2));
        Section s9 = repoS.save(new Section(9,10109,cou1,p2));
        Section s10 = repoS.save(new Section(10,10110,cou1,p2));
        Section s11 = repoS.save(new Section(11,10111,cou1,p2));
        Section s12 = repoS.save(new Section(12,10112,cou1,p2));
        Section s13 = repoS.save(new Section(13,10113,cou1,p2));
        Section s14 = repoS.save(new Section(14,10114,cou1,p2));
        Section s15 = repoS.save(new Section(15,10115,cou1,p2));
        Section s16 = repoS.save(new Section(16,10116,cou1,p2));
        Section s17 = repoS.save(new Section(17,10117,cou1,p2));
        Section s18 = repoS.save(new Section(18,10118,cou1,p2));
        Section s19 = repoS.save(new Section(19,10119,cou1,p2));
        Section s20 = repoS.save(new Section(20,10120,cou1,p2));
        Section s21 = repoS.save(new Section(21,10121,cou1,p2));
        Section s22 = repoS.save(new Section(22,10122,cou1,p2));
        Section s23 = repoS.save(new Section(23,10123,cou1,p2));
        Section s24 = repoS.save(new Section(24,10124,cou1,p2));
        Section s25 = repoS.save(new Section(25,10125,cou1,p2));
        Section s26 = repoS.save(new Section(26,10201,cou2,p2));
        Section s27 = repoS.save(new Section(27,10202,cou2,p2));
        Section s28 = repoS.save(new Section(28,10203,cou2,p2));
        Section s29 = repoS.save(new Section(29,10204,cou2,p2));
        Section s30 = repoS.save(new Section(30,10205,cou2,p2));
        Section s31 = repoS.save(new Section(31,10206,cou2,p2));
        Section s32 = repoS.save(new Section(32,10207,cou2,p2));
        Section s33 = repoS.save(new Section(33,10208,cou2,p2));
        Section s34 = repoS.save(new Section(34,10209,cou2,p2));
        Section s35 = repoS.save(new Section(35,10210,cou2,p2));
        Section s36 = repoS.save(new Section(36,10211,cou2,p2));
        Section s37 = repoS.save(new Section(37,10212,cou2,p2));
        Section s38 = repoS.save(new Section(38,10213,cou2,p2));
        Section s39 = repoS.save(new Section(39,10214,cou2,p2));
        Section s40 = repoS.save(new Section(40,10215,cou2,p2));
        Section s41 = repoS.save(new Section(41,10216,cou2,p2));
        Section s42 = repoS.save(new Section(42,10217,cou2,p2));
        Section s43 = repoS.save(new Section(43,10218,cou2,p2));
        Section s44 = repoS.save(new Section(44,10219,cou2,p2));
        Section s45 = repoS.save(new Section(45,10220,cou2,p2));
        Section s46 = repoS.save(new Section(46,10221,cou2,p2));
        Section s47 = repoS.save(new Section(47,10222,cou2,p2));
        Section s48 = repoS.save(new Section(48,10223,cou2,p2));
        Section s49 = repoS.save(new Section(49,10224,cou2,p2));
        Section s50 = repoS.save(new Section(50,10225,cou2,p2));
        Section s51 = repoS.save(new Section(51,10301,cou3,p2));
        Section s52 = repoS.save(new Section(52,10302,cou3,p2));
        Section s53 = repoS.save(new Section(53,10303,cou3,p2));
        Section s54 = repoS.save(new Section(54,10304,cou3,p2));
        Section s55 = repoS.save(new Section(55,10305,cou3,p2));
        Section s56 = repoS.save(new Section(56,10306,cou3,p2));
        Section s57 = repoS.save(new Section(57,10307,cou3,p2));
        Section s58 = repoS.save(new Section(58,10308,cou3,p2));
        Section s59 = repoS.save(new Section(59,10309,cou3,p2));
        Section s60 = repoS.save(new Section(60,10310,cou3,p2));
        Section s61 = repoS.save(new Section(61,10311,cou3,p2));
        Section s62 = repoS.save(new Section(62,10312,cou3,p2));
        Section s63 = repoS.save(new Section(63,10313,cou3,p2));
        Section s64 = repoS.save(new Section(64,10314,cou3,p2));
        Section s65 = repoS.save(new Section(65,10315,cou3,p2));
        Section s66 = repoS.save(new Section(66,10316,cou3,p2));
        Section s67 = repoS.save(new Section(67,10317,cou3,p2));
        Section s68 = repoS.save(new Section(68,10318,cou3,p2));
        Section s69 = repoS.save(new Section(69,10319,cou3,p2));
        Section s70 = repoS.save(new Section(70,10320,cou3,p2));
        Section s71 = repoS.save(new Section(71,10321,cou3,p2));
        Section s72 = repoS.save(new Section(72,10322,cou3,p2));
        Section s73 = repoS.save(new Section(73,10323,cou3,p2));
        Section s74 = repoS.save(new Section(74,10324,cou3,p2));
        Section s75 = repoS.save(new Section(75,10325,cou3,p2));
        
    }
    
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
    
}

