package ir.sareyhoon.develope.engine.dialog.yesno;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class YesNo implements Serializable {
    private String title;
    private String body;
    private String positive;
    private String negative;

}
