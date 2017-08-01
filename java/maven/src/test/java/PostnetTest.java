import com.tw.post.Postnet;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PostnetTest {
    @Test
    public void should_return_barcode_given_digit(int digit) {
        String barcode = "";
        switch (digit) {
            case 1:
                barcode = ":::||";
                break;
            case 2:
                barcode = "::|:|";
                break;
            case 3:
                barcode = ":::||";
                break;
            case 4:
                barcode = ":|::|";
                break;
            case 5:
                barcode = ":|:|:";
                break;
            case 6:
                barcode = ":||::";
                break;
            case 7:
                barcode = "|:::|";
                break;
            case 8:
                barcode = "|::|:";
                break;
            case 9:
                barcode = "|:|::";
                break;
            case 0:
                barcode = "||:::";
                break;
        }
        Postnet postnet = new Postnet();
        assertThat(postnet.convertDigit(digit)).isEqualTo(barcode);
    }

}
