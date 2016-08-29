package adityagurjar.people;

/**
 * Created by adi on 28/8/16.
 */
public class contactitem {
        private String title, number,email;

        public contactitem() {
        }

        public contactitem(String title, String number,String email) {
            this.title = title;
            this.number=number;
            this.email=email;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String name) {
            this.title = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
