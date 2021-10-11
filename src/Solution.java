
public class Solution {
    private int numerator;
    private int denomanator ;
    public int getNumerator(){
        return numerator;
    }
    public int getDenominator(){
        return denomanator;
    }
    public void setNumerator(int numerator){
        this.numerator = numerator;
    }
    public void setDenominator(int denomanator){
        this.denomanator = denomanator;
    }
    public Solution(int numerator, int denomanator){
        super();
        this.numerator = numerator;
        if (denomanator == 0){
            this.denomanator = 1;
        }
        else
            this.denomanator = denomanator;
    }
    public int timUSCLN(int a, int b) {

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    public Solution reduse() {
        int i = timUSCLN(this.getNumerator(), this.getDenominator());
        this.setNumerator(this.getNumerator() / i);
        this.setDenominator(this.getDenominator() / i);
        return new Solution(this.getNumerator(),this.getDenominator());
    }
    public Solution add(Solution ps) {
        int ts = this.getNumerator() * ps.getDenominator() + ps.getNumerator() * this.getDenominator();
        int ms = this.getDenominator() * ps.getDenominator();
        Solution add = new Solution(ts, ms);
        add.reduse();
        return add;
    }

    public Solution subtract(Solution ps) {
        int ts = this.getNumerator() * ps.getDenominator() - ps.getNumerator() * this.getDenominator();
        int ms = this.getDenominator() * ps.getDenominator();
        Solution phanSoHieu = new Solution(ts, ms);
        phanSoHieu.reduse();
        return phanSoHieu;
    }

    public Solution multiply(Solution ps) {
        int ts = this.getNumerator() * ps.getNumerator();
        int ms = this.getDenominator() * ps.getDenominator();
        Solution phanSoTich = new Solution(ts, ms);
        phanSoTich.reduse();
        return phanSoTich;
    }

    public Solution divide(Solution ps) {
        if(ps.getNumerator() == 0){
            return new Solution(this.getNumerator(),this.getDenominator());
        }
        int ts = this.getNumerator() * ps.getDenominator();
        int ms = this.getDenominator() * ps.getNumerator();
        Solution phanSoThuong = new Solution(ts, ms);
        phanSoThuong.reduse();
        return phanSoThuong;
    }
    public boolean equals(Object obj){
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            other.reduse();
            this.reduse();
            if(other.getNumerator() == this.getNumerator() && other.getDenominator() == this.getDenominator()){
                return true;
            }
            else return false;
        }
        else return false;
    }
}