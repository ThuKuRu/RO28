public class Department {
        int     departmentID;

        String  departmentName;

        public Department(){

        }

        public Department(String name){
            this.departmentID = 1;
            this.departmentName = name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "departmentID=" + departmentID +
                    ", departmentName='" + departmentName + '\'' +
                    '}';
        }

}
