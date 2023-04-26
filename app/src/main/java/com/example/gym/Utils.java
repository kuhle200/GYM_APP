package com.example.gym;

import java.util.ArrayList;

public class Utils {

    private static ArrayList<Training> trainings;
    private static ArrayList<Plan> plans;

    public static void initialTrainings(){
        if(null == trainings){
            trainings = new ArrayList<>();
        }

        Training pushUps = new Training(
                1,
                "push ups",
                "Push-ups are an exercise in which a person, keeping a prone position, with the hands palms down under the shoulders, the balls of the feet on the ground, and the back straight, pushes the body up and lets it down by an alternate straightening and bending of the arms.",
                "Push-ups are an exercise in which a person, keeping a prone position, with the hands palms down under the shoulders, the balls of the feet on the ground, and the back straight, pushes the body up and lets it down by an alternate straightening and bending of the arms.",
                "data:image/jpeg;base64,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");

        trainings.add(pushUps);

        Training squat = new Training(
                2,
                "squat",
                "The squatting movement is initiated by moving the hips back and bending the knees and hips to lower the torso and accompanying weight, then returning to the upright position. Squats can be performed to varying depths.",
                "The squatting movement is initiated by moving the hips back and bending the knees and hips to lower the torso and accompanying weight, then returning to the upright position. Squats can be performed to varying depths.",
                "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw8NDQ4NDhAQDQ0NDQ0NDg4OEBANDg0OFhEWFhURFRUYHSggGBomHhUVITEhJSsrMC4uFyA0OTksOSgtMDABCgoKDg0OGxAQGC0mICUtLS0vLSstLSsvMC0tLy4vLS04Ly0tLS0tMC0tKystLS0tLS0tLS0tLTAvLS0tLS0tLf/AABEIAKgBKwMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAABQYBAwQHAgj/xAA5EAACAgEBBAgFAgQGAwAAAAAAAQIDEQQFEiExBhRBUVJhgaETIjJxkUKxI4LB0QczYnLC4RVzkv/EABsBAQACAwEBAAAAAAAAAAAAAAAEBQEDBgIH/8QALhEAAgECBAMHBAMBAAAAAAAAAAECAxEEEiExQVFhBRNxgZGh8CIyscFC0eEU/9oADAMBAAIRAxEAPwC2gAnHPgAAAAAAAAAAAAAAAAAAAAAAq/8AiNtKzTaD+G5Rd1ypc4vG5FqTfHzxj1MSeVXPdODnNRXEtAPz1RtW6qU3TbZXKaxOVc5Qcl2p45noP+GnSLV6i16S1u+muhyVsuM6sPCUpfqznhnjwNcat3axJq4Nwi5KV7eX9r3PRAAbSGAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACL6UWQhs/WTtgrIR0tuYS4Kfy8FlcuOOJKHDt3R9Y0epoWW7dPbCOOe84vd98B7GYtXVzxPYGxZX2QTxuN4bksr1PStF0Uopsg6l8O6C3o3QbhNP04Y8uTIzZ2zKqroWx41qEVwbllbvPy45JqzRX22wuo1GKYSjxjKSe74MZ45+xS1KmbZ2OxhQyLVX9yy6axygnL6lwljlvLng2HHsuM1Gx2PLlfNx8obsUl7Z9TsLajJypxb5HKYmEYVpxjsmwADYaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADXddGuLnOShFc23hHxoLVrIWKmTqnHG45qPzx7Ws8vXy9NdSrCn9z8uJIoYWrXf0LTnw+eFyq7Wrq0tl04RxCVr38dkpfPLH80pP1ObTar+HKFSVkbODWZ8O55i8r0JXaemSTpksxeXl5cnLnl57TPRrZ1NMbbZxg5byt35xTcOfJvly7CnS72rba7fhzOpc/8Anw6dnLKktN3sv2TugpddNcJfUoRUsNv5sceL4v1N5Gf+WfzydUtyGXvLceYpZbxvZ9u1EhRarIRnHjGUVJPvTWUy2pVacvpg9jmcThq9N95VW75p6vXg9D7ABuIgAAAAAAAAAAAAAAAAAAAAABgAGQYABkAAAAAAGDIAAAABgyAAAAVnb9yu1MaW/krxldjm+b9Fhfk26NvSTjavphKLksZbhnE0vPdbIba9rWpsW7JSVtnzY+VrezzJWmbuoa7ZRcfXBRVpXqOT5/g7PDU1ToRgtrL339ywbao305wSnPk1w+b/AFR8/I4Vsy2yrU7tbi5aeVdUJvc35uUWnh927z7x1tKuKy/lSXHOTVtjVWWaOdGnsdWo1EXXCyOVKtfqlw4rhwyu89ZYPW5slGrG7UXbwaIXZ9dstNqVu/DsVGorTlh7tqi0l3PEiz7Jo+Fp6q23J11V1uT5ycYxjn2KTo9l62mq3STsjOiqlWQcZS+JO1Szh57OD9Wi39HtWrtPCWcylGLfel2+6ZuwmVVrXvo7fPC5X9qZpYXNbir/ADxaJIAFqcwAAAAAAAYMgAAAAAAAAAAAyZBgAGAAAAAAAAAAAAAAAAAAAADn12rhRBzn9lFfVJ9yDaSuz1GLk1GKu3wOPaGmpssW/CDlhZbxF+XHtIfQTVU50yafFqLT4N9jPh7R+MpO5JScm+WYtZ4L0OPUNN78JRco9illyX2KCpUvOT4Ns+hUcKnhaai1mjFJpc0kn+P6Ja++Cks85ReEuLlJdiXqbdK91OyXGbWEvCuxIh9LNWT+Jhp4UZN/sid2XT8Wzff0V8v9/Z/cxTpuc1GO7+XImIxPd0by+2PvyXrojF9PwLIWSzu2xUZ5fBWJcvx+zIrovqPhSshn5a7pw/kcsf2foWrX6VX1SrfDeXyPwzXJlB2dJ06i2uXBuUlJPslniiTiafcTUobbry39f2QOz66xlCVOrq1o/B7P8rpoz0UGjZ896mvLy1XFN97XD+hvLZO6ujl5wcJOL4Nr00AAMnkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA+L7VBZfoueZEHtLN2G3iUc7qf04fNex27Qsbmo8kox/L4/2OW2pbrcptJdrwkivxM3JuPBHd9idm0aWGjVmvqmr35J7JctNXxv0RWNbdFNxacZLsfBo5FNtNywopNtvuJjUQrse43XauzL3Wvtnin9ng0LZKX6pqL7HuS9yvlHkWDwT/g00c2y9FLU3VxrnuKScnwbioJZzjK8vyehaaiNUIwisRisffzKFKXwXu0OUcPjNPE5P7rsJLR9MFBqu2udqjwndBJpeXn9ybhKkKa+rfn0KTtrszEyipQaaX8dnfmr/dp5rdXLeQ21+j0NTP40Juq7CTko70Z+bWVx88kjoddVqI71U1Lvj+uP3T4o6CwlGFWNnqjladSrh6l43jJfLNP9r0NWloVVcK1xUIpZfa+1m0A9pJKyNUm5Nt7sAAGAAAAAAAAAAAAAAAAAAACX6rX4V7jqtfhXuLnrIyIBL9Vr8K9x1Wvwr3FxkZEAl+q1+Fe46rX4V7i4yMiAS/Va/CvcdVr8K9xcZGRAJfqtfhXuOq1+Fe4uMjIgEv1Wvwr3HVa/CvcXGRkQCX6rX4V7jqtfhXuLmcjKptVbrVj4Rwk33Nf9fsQ0NS7Xl/TyS7l/cvut2ZTfVOqUcRmsJr6oy7JLzPO9foL9n2blqzXJv4dqXyTX9H5fuVuLptPMtmdX2dj+9w8cO3rHTxS29FuuWvO2dXoM8V98rmjm1Fk64qOMPtmlzJHSavfxF9p06jQrtW9Hg5LLi8eTXIgrR3LXDYh0ZdOKIjT0Rlwckm1x/wBK7vud8dDFRwmt3GEuBu1PQubhG7Q2/EhJKSquajPj2KS4N/fH3IezS66h4s09681XKcfzHKNlSlUjuvTVGl46liZXU14PRryeps+E6rMxbi1yknhr1J7SbXkor4n8SPbKKSs9VyfsVe7VPgrFKMn4k4v3NdGvlCXB5XnyNdOrOm7xfzwPFfCU66tUjf8APk1/p6Dp9RC2O9CSkvLsfc12G0q2ytZGNldkVhuUY2Qz8tkW8NY7y/8AVq/CvcuMNiO9jdrVHK47AvDTST0e19/nUiQS/Va/CvcdVr8K9yRcg5GRAJfqtfhXuOq1+Fe4uMjIgEv1Wvwr3HVa/CvcXGRkQCX6rX4V7jqtfhXuLjIyIBL9Vr8K9x1Wvwr3FxkZEAl+q1+Fe46rX4V7i4yMiAS/Va/CvcdVr8K9xcZGbgAeTYAAAAAAAAAAAAAAAAAADl2hVTOmcdQoypxmfxPpSXb5PzOop/THaG9NadP5K8SsS/Va+OH9l7vyNVaoqcG2ScLQlWqqMXbjfl18eXUgtRTTCyctPvxp4bqteZZ712peTyz4W1bJz+HHMm8QSSzvN8OBx33ymnGPHPBJcXnsSLt0T6NLSpX3pPUSXyx5qlP/AJfsVVOnKtLTz6HS4itDC0809eSe7+cWTmzNM6aKqnzhD5v9z4v3bOoAuUklZHJyk5Nylu9SK6R62ujTSdkI3OXyV1TSnGc2u1PsXNnlD07rk25KW828YUVHL5LHYW7pbtBWamXHMNPF1x7nPPzteuF/KRGw9k2a+9qOY1xw7J44Qj3Lvk+xFViakqtXJHwOn7Ooww2H7yel9X0XD28236SfQzZUr7VfJYpqlnL/AF2rior7cG/Q9CNGk00KK4VVrdhBbsV/V97N5YUKSpRsUONxbxNXPw2S6f293/gABuIgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABzbQ1aopna+O6uC8U3wS/J5XtHWOUpZe9KTbk32t82Wfpzthb8dPB/5fzWf+xrl6L9zX0N6PK3Gs1C3o5fwK3yeH9cu/jyX/RXYi9ar3ceHxnRYBQwmGdep/LbryXnq/D36Oh3R1x3dXesP6qa2uK7rJLv7l6lyAJtOnGnHKilxOJniKmefpwS5fNwRPSbaq0emlNP+LP+FUu6T5y9Fx/BIamSjCcm2lXCU202vpTZ5LtGzVa25O63MIZjGUt3MYvi0orHHPf3LiasTW7uNluyb2Z2e8TLPvGLV1z3t04a6/5v2bo7NffGmHBY3pyfFRhn5pPvfl2s9P2boK9LVGmpYjHm/wBU5ds5PtbKz0N+HpE6/q+Lut3N8d5LCjhco8WW9GvBQio5lvx6G/tydZVlSmrR3XXm/J6W4LxMgAmlGAAAAAAAAAAAAAAAAADIAAMAAAAAAAAAAAAAAAAAAAjtvauyjTynTj4re5By4KMmm8v/AOSROHa2md1aSWWnng0mvPjzNdXNkeXclYLuv+iHe/bfW/zmUSvY9T/zVK6yTcpTk2k5ZzyT4/uegbOUVRSoYUVTXHC5JKOMFahTKDxKMuDayotx/JL7I1D+jnBt4aXBT5kDCzUJ2fHQ6ntrC97h1Klb6ddOKt8fVX4kuACzOMNGuodtU64yUHJJZccrGeKaz2rh6lYv6JzfGPwk/KyyK/G4y3A1zpQn9yJmGx1fDpqlK3EptXRzU1vKaf2cWvy91+xM6CvVQcVJ5jwzvPMUvyTINSwsE7xbRLn2ziKkMlRRkusb/sAAklQAADIAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAAAAAAAAGuymMvqhF/ePE+IaWuL3lCKa5PGWvsZAsrntSklZN/OmxuAAPAAAAAAMgAAGAADIAABkwAYMoyYMgyYQAADAABgAAGD//Z"
        );

        trainings.add(squat);

        Training legPress = new Training(
                3,
                "leg press",
                "The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press machine refers to the apparatus used to perform this exercise.",
                "The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press machine refers to the apparatus used to perform this exercise.",
                "data:image/jpeg;base64,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"
        );

        trainings.add(legPress);

        Training pullUps = new Training(
                4,
                "Pull ups",
                "Pull ups are a great exercise for strengthening the back, biceps, and shoulders.",
                "Pull ups are a great exercise for strengthening the back, biceps, and shoulders.",
                "data:image/jpeg;base64,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"
        );

        trainings.add(pullUps);


    }

    public static ArrayList<Training> getTrainings() {
        return trainings;
    }

    public static boolean addPlan(Plan plan){

        if(plans ==null){
            plans = new ArrayList<>();
        }
        return plans.add(plan);
    }

    public static ArrayList<Plan> getPlans() {
        return plans;
    }

    public static boolean removePlan(Plan plan){
        return plans.remove(plan);

    }
}