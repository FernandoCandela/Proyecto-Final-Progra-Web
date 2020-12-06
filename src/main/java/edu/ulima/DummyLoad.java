package edu.ulima;

import edu.ulima.entidad.Country;
import edu.ulima.entidad.Gender;
import edu.ulima.entidad.Career;
import edu.ulima.entidad.Course;
import edu.ulima.entidad.TeacherType;
import edu.ulima.entidad.Period;
import edu.ulima.entidad.Section;
import edu.ulima.entidad.Student;
import edu.ulima.entidad.Teacher;
import edu.ulima.entidad.User;
import edu.ulima.entidad.UserStudent;
import edu.ulima.entidad.UserTeacher;
import edu.ulima.entidad.SectionStudent;
import edu.ulima.entidad.SectionTeacher;
import edu.ulima.persistencia.CareerRepositorio;
import edu.ulima.persistencia.CountriesRepositorio;
import edu.ulima.persistencia.CourseRepositorio;
import edu.ulima.persistencia.GenderRepositorio;
import edu.ulima.persistencia.PeriodRepositorio;
import edu.ulima.persistencia.SectionRepositorio;
import edu.ulima.persistencia.StudentRepositorio;
import edu.ulima.persistencia.TeacherRepositorio;
import edu.ulima.persistencia.TeacherTypeRepositorio;
import edu.ulima.persistencia.SectionStudentRepositorio;
import edu.ulima.persistencia.SectionTeacherRepositorio;
import edu.ulima.persistencia.UserRepositorio;
import edu.ulima.persistencia.UserStudentRepositorio;
import edu.ulima.persistencia.UserTeacherRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

    @Autowired
    private StudentRepositorio repoStud;

    @Autowired
    private TeacherRepositorio repoTeach;

    @Autowired
    private SectionStudentRepositorio repoSecStd;

    @Autowired
    private SectionTeacherRepositorio repoSecTea;

    @Autowired
    private UserRepositorio repoUser;

    @Autowired
    private UserStudentRepositorio repoUsStd;

    @Autowired
    private UserTeacherRepositorio repoUsTea;

    @Override
    public void run(String... args) throws Exception {
        // Aqui se ejecuta la logica principal
        // INSERT - save
        // DELETE - remove
        // UPDATE  - merge
        // SELECT find - select

        //USER 
        User us1 = repoUser.save(new User(1));
        User us2 = repoUser.save(new User(2));
        User us3 = repoUser.save(new User(3));
        User us4 = repoUser.save(new User(4));
        User us5 = repoUser.save(new User(5));
        User us6 = repoUser.save(new User(6));
        User us7 = repoUser.save(new User(7));
        User us8 = repoUser.save(new User(8));
        User us9 = repoUser.save(new User(9));
        User us10 = repoUser.save(new User(10));

        //GENDER
        Gender g1 = repoG.save(new Gender(1, "MASCULINO"));
        Gender g2 = repoG.save(new Gender(2, "FEMENINO"));
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

        //TEACHERTYPE
        TeacherType te1 = repoTeType.save(new TeacherType(1, "PROFESOR"));
        TeacherType te2 = repoTeType.save(new TeacherType(2, "JEFE DE PRACTICAS"));
        //PERIOD
        Period p1 = repoP.save(new Period(1, "2020-0"));
        Period p2 = repoP.save(new Period(2, "2020-1"));
        //SECTION
        Section s1 = repoS.save(new Section(1, 10101, cou1, p2));
        Section s2 = repoS.save(new Section(2, 10102, cou1, p2));
        Section s3 = repoS.save(new Section(3, 10103, cou1, p2));
        Section s4 = repoS.save(new Section(4, 10104, cou1, p2));
        Section s5 = repoS.save(new Section(5, 10105, cou1, p2));
        Section s6 = repoS.save(new Section(6, 10106, cou1, p2));
        Section s7 = repoS.save(new Section(7, 10107, cou1, p2));
        Section s8 = repoS.save(new Section(8, 10108, cou1, p2));
        Section s9 = repoS.save(new Section(9, 10109, cou1, p2));
        Section s10 = repoS.save(new Section(10, 10110, cou1, p2));

        //COUNTRIES
        Country coun1 = repoCoun.save(new Country(1, "France"));
        Country coun2 = repoCoun.save(new Country(2, "Greece"));
        Country coun3 = repoCoun.save(new Country(3, "Indonesia"));
        Country coun4 = repoCoun.save(new Country(4, "Japan"));
        Country coun5 = repoCoun.save(new Country(5, "Russia"));
        Country coun6 = repoCoun.save(new Country(6, "China"));
        Country coun7 = repoCoun.save(new Country(7, "Ukraine"));
        Country coun8 = repoCoun.save(new Country(8, "United States"));
        Country coun9 = repoCoun.save(new Country(9, "Thailand"));
        Country coun10 = repoCoun.save(new Country(10, "Pakistan"));

        //STUDENT
        Student stud1 = repoStud.save(new Student(1, 2020001, "Cherlyn Jobye", "Aarons Daubeny", "2020001@universdiad.edu.com", "jdaubenygr@is.gd", "8 997 382 563", "3OV0QC", "730 325 950", g2, c4, coun1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud2 = repoStud.save(new Student(2, 2020002, "Gretel Myrlene", "Abadam Northill", "2020002@universdiad.edu.com", "mnorthill1c@cbc.ca", "8 244 659 204", "uMmEp5", "812 759 720", g2, c4, coun2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud3 = repoStud.save(new Student(3, 2020003, "Aylmar Goober", "Abercrombie Iashvili", "2020003@universdiad.edu.com", "giashviliz@apple.com", "2 755 254 534", "87XrgD", "476 221 171", g1, c5, coun3, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud4 = repoStud.save(new Student(4, 2020004, "Meade Shay", "Abrahams Moisey", "2020004@universdiad.edu.com", "smoisey0@google.de", "7 512 372 624", "uijzAh", "277 809 536", g2, c5, coun1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud5 = repoStud.save(new Student(5, 2020005, "Chip Daren", "Ackerley Canning", "2020005@universdiad.edu.com", "dcanning8z@independent.co.uk", "5 332 944 231", "lK6MGN", "580 114 901", g1, c4, coun4, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud6 = repoStud.save(new Student(6, 2020006, "Marguerite Greer", "Adamolli Burkwood", "2020006@universdiad.edu.com", "gburkwood6t@wiley.com", "10 247 694 275", "yqdRre", "669 446 879", g2, c5, coun3, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud7 = repoStud.save(new Student(7, 2020007, "Gannie Ludvig", "Aguilar Thornewill", "2020007@universdiad.edu.com", "lthornewill7b@youtube.com", "1 539 315 571", "jaseRC", "235 718 338", g1, c1, coun5, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud8 = repoStud.save(new Student(8, 2020008, "Jameson Bernardo", "Ahrendsen Hanniger", "2020008@universdiad.edu.com", "bhannigerb0@blogspot.com", "2 971 930 893", "S8lmjN", "279 513 932", g1, c1, coun6, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud9 = repoStud.save(new Student(9, 2020009, "Valma Brit", "Ailward Shervington", "2020009@universdiad.edu.com", "bshervingtonm8@altervista.org", "7 131 199 158", "bnp0xt", "324 712 859", g2, c5, coun7, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud10 = repoStud.save(new Student(10, 2020010, "Jenni Iris", "Alabone Radborne", "2020010@universdiad.edu.com", "iradborneep@sitemeter.com", "2 188 472 726", "NL82Hh", "920 638 720", g2, c4, coun8, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Student stud11 = repoStud.save(new Student(11, 2020011, "Willy Guenna", "Alekseev Geri", "2020011@universdiad.edu.com", "ggerij7@sciencedirect.com", "5 719 249 140", "lPUId0", "955 383 240", g2, c3, coun9, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));

        //TEACHERS
        Teacher teach1 = repoTeach.save(new Teacher(1, 45001, "Cherlyn Jobye", "Aarons Daubeny", "caarons@universidad.edu.com", "jdaubenygr@is.gd", g2, coun1, te1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach2 = repoTeach.save(new Teacher(2, 45002, "Gretel Myrlene", "Abadam Northill", "gabadam@universidad.edu.com", "mnorthill1c@cbc.ca", g2, coun2, te1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach3 = repoTeach.save(new Teacher(3, 45003, "Aylmar Goober", "Abercrombie Iashvili", "aabercr@universidad.edu.com", "giashviliz@apple.com", g1, coun3, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach4 = repoTeach.save(new Teacher(4, 45004, "Meade Shay", "Abrahams Moisey", "mabraha@universidad.edu.com", "smoisey0@google.de", g2, coun1, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach5 = repoTeach.save(new Teacher(5, 45005, "Chip Daren", "Ackerley Canning", "cackerl@universidad.edu.com", "dcanning8z@independent.co.uk", g1, coun4, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach6 = repoTeach.save(new Teacher(6, 45006, "Marguerite Greer", "Adamolli Burkwood", "madamol@universidad.edu.com", "gburkwood6t@wiley.com", g2, coun3, te1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach7 = repoTeach.save(new Teacher(7, 45007, "Gannie Ludvig", "Aguilar Thornewill", "gaguila@universidad.edu.com", "lthornewill7b@youtube.com", g1, coun5, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach8 = repoTeach.save(new Teacher(8, 45008, "Jameson Bernardo", "Ahrendsen Hanniger", "jahrend@universidad.edu.com", "bhannigerb0@blogspot.com", g1, coun6, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach9 = repoTeach.save(new Teacher(9, 45009, "Valma Brit", "Ailward Shervington", "vailwar@universidad.edu.com", "bshervingtonm8@altervista.org", g2, coun7, te2, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));
        Teacher teach10 = repoTeach.save(new Teacher(10, 45010, "Jenni Iris", "Alabone Radborne", "jalabon@universidad.edu.com", "iradborneep@sitemeter.com", g2, coun8, te1, "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"));

        //SECTION_STUDENTS
        repoSecStd.save(new SectionStudent(1, s1, stud1));
        repoSecStd.save(new SectionStudent(2, s1, stud2));
        repoSecStd.save(new SectionStudent(3, s1, stud3));
        repoSecStd.save(new SectionStudent(4, s1, stud4));
        repoSecStd.save(new SectionStudent(5, s1, stud5));
        repoSecStd.save(new SectionStudent(6, s1, stud6));
        repoSecStd.save(new SectionStudent(7, s1, stud7));
        repoSecStd.save(new SectionStudent(8, s1, stud8));
        repoSecStd.save(new SectionStudent(9, s1, stud9));
        repoSecStd.save(new SectionStudent(10, s1, stud10));
        repoSecStd.save(new SectionStudent(11, s1, stud11));

        //SECTIONTEACHER
        repoSecTea.save(new SectionTeacher(7, s4, teach1));

        repoSecTea.save(new SectionTeacher(15, s8, teach6));
        repoSecTea.save(new SectionTeacher(16, s8, teach7));

        //USER STUDENT
        UserStudent ustd1 = repoUsStd.save(new UserStudent(1, us1, stud1, "2020001", "EIPPUL", "FYxuKLShMAYsypETmgoQ", "y7Mc5gjPkXvJpbBBJusd"));
        UserStudent ustd2 = repoUsStd.save(new UserStudent(2, us2, stud2, "2020002", "j2yEfM", "ghuLzkghcHcRhV6CFmpj", "vBSGYXFK4x2KvrwMGuWF"));
        UserStudent ustd3 = repoUsStd.save(new UserStudent(3, us3, stud3, "2020003", "MybyIK", "tI2E6Lm3GdpGgW5TpvI1", "faWCUDdxCIRwQuKMgMdt"));
        UserStudent ustd4 = repoUsStd.save(new UserStudent(4, us4, stud4, "2020004", "1cjZOM", "7ABIjLfJPBCN4GwF0SJ5", "3zGS5Hfp1GFFC0jREOS1"));
        UserStudent ustd5 = repoUsStd.save(new UserStudent(5, us5, stud5, "2020005", "MlBMc0", "nT79kkAFniwuqdG8gy2r", "rgWSwjblwewTp8iMZPVm"));
        UserStudent ustd6 = repoUsStd.save(new UserStudent(6, us6, stud6, "2020006", "ya4w1d", "KnnwZPuLQMVAUt5csdID", "XkfYhdg7F4dQNo9CIbHY"));
        UserStudent ustd7 = repoUsStd.save(new UserStudent(7, us7, stud7, "2020007", "ArRV2E", "oGOaKwGOZsNpYwFZGeAI", "JR59EFcZL98B1xoKRFfL"));
        UserStudent ustd8 = repoUsStd.save(new UserStudent(8, us8, stud8, "2020008", "UXXQxN", "tZAf2Sqr9Efb7VYDRZmp", "dLRvli94VNYcyiEBoweP"));
        UserStudent ustd9 = repoUsStd.save(new UserStudent(9, us9, stud9, "2020009", "Wf53GQ", "WxWMJ4Z5kzYemszl8FdE", "fYbuR9rikHzQx6kadu8Q"));
        UserStudent ustd10 = repoUsStd.save(new UserStudent(10, us10, stud10, "2020010", "lTEqmm", "Q3Zy4ZhOcFEdjhEfBv5T", "xrJT2R4IifVaudQ68ruu"));

        //USER TEACHER
        UserTeacher ustea1 = repoUsTea.save(new UserTeacher(1, "45001", "ov0291", "fAL19qszEBxUXPGIJ4S6", "aXmLP492oJdXxoYoSB2M", us1, teach1));
        UserTeacher ustea2 = repoUsTea.save(new UserTeacher(2, "45002", "Zr9WNo", "56J0IHAJqAtbU8s1lrDO", "DCzpajgMuv3jwXB0CwoS", us2, teach2));
        UserTeacher ustea3 = repoUsTea.save(new UserTeacher(3, "45003", "Xl6xBA", "xBxCJqKUlNIk4J1uujFa", "Ngto50dXd6CCjA8A0475", us3, teach3));
        UserTeacher ustea4 = repoUsTea.save(new UserTeacher(4, "45004", "Fhv3aC", "VbAD7QqnGTEzOUAsCcDA", "br8dQw0OM5qf3xcbH2fL", us4, teach4));
        UserTeacher ustea5 = repoUsTea.save(new UserTeacher(5, "45005", "OopvGZ", "rL0UB9POxYcFkWKM2Icl", "lofx6yZBIPqBkoOzuwFT", us5, teach5));
        UserTeacher ustea6 = repoUsTea.save(new UserTeacher(6, "45006", "0djAgq", "8KVjd7S98AjJs0LhgKPp", "5xTVcsAnlugAAWm7iWwF", us6, teach6));
        UserTeacher ustea7 = repoUsTea.save(new UserTeacher(7, "45007", "ANeXmK", "QGsTgNknyNo4uRxm5Jis", "NggrAYfZLFHmBOrm4L31", us7, teach7));
        UserTeacher ustea8 = repoUsTea.save(new UserTeacher(8, "45008", "gY5USj", "KzV8mWufW85rlGmVkyDb", "LPOzVlr1uzrbwuCs3Gwc", us8, teach8));
        UserTeacher ustea9 = repoUsTea.save(new UserTeacher(9, "45009", "WrNL0e", "IyqkwbZDsYadVSUqBRe8", "lAWBNU2Ny0HvbiIcDeT1", us9, teach9));
        UserTeacher ustea10 = repoUsTea.save(new UserTeacher(10, "45010", "pRPHhU", "L9yWzOiVoKq2XjpLXFkB", "0iU3kYKsVG2AZxl8xjBn", us10, teach10));

    }

}
