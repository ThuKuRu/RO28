package com.vti.entity.Encapsulation;

public class Student {
        private int id;

        private String name;

        private String hometown;

        private float score;

        public  Student(String name, String hometown){
            this.name = name;
            this.hometown = hometown;
            this.score = 0;
        }

        public int getId(){
            return id;
        }

        public void setId(){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(){
            this.name = name;
        }

        public String getHometown(){
            return hometown;
        }

        public void setHometown(){
            this.hometown = hometown;
        }

        public float getScore(int i){
            return score;
        }

        public void setScore(int i){
            this.score = i;
        }

        public void plusScore(int i){
            this.score += i;
        }


        @Override
        public String toString() {
            String rate;
            if (score < 4.0) {
                rate = "Yếu";
            } else if (score < 6) {
                rate = "Trung bình";
            } else if (score < 8) {
                rate = "Khá";
            } else {
                rate = "Giỏi";
            }
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", hometown='" + hometown + '\'' +
                    ", diem=" + score +
                    ", xepLoai=" + rate +
                    '}';
        }

}
