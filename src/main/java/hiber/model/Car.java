package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;
    @Column(name = "marka")
    private String marka;
    @Column(name = "series")
    private int series;

    public Car(String model, String marka, int series) {
        this.model = model;
        this.marka = marka;
        this.series = series;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return "Cars{" +
                "model='" + model + '\'' +
                ", marka='" + marka + '\'' +
                ", series=" + series +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
