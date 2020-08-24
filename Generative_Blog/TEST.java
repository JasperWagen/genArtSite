import java.util.Set;
import java.util.HashSet;

public class TEST{
    public Integer testID;
    public Integer myInt;
    public Float myFloat;
    public String myString;

    public TEST(Integer myInt, Float myFloat) {
        this.myInt = myInt;
        this.myFloat = myFloat;
        this.testID = allTests().size();
    }

    public void addString(String string){
        myString = string;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    private static Set<TEST> testSet;

    static {
        testSet = new HashSet<>();

        testSet.add(new TEST(1,1F));
        testSet.add(new TEST(2,2F));
    }

    public static Set<TEST> allTests(){
        return testSet;
    }

    public static TEST findById(Integer id){
        for(TEST test: testSet){
            if(id.equals(test.testID)) {
                return test;
            }
        }

        return null;
    }

    public static void main(String []args) {
        TEST testInstance = new TEST(4, 4.02F);
        testSet.add(testInstance);

        testSet.add(new TEST(77, 55F));

        System.out.println(findById(0).myInt);
    }
}

