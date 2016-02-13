package hu.tilos.radio.backend.scheduling;

import hu.tilos.radio.backend.NewsBlock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Monday implements BaseScheduling {


    @Override
    public List<NewsBlock> createBlocks(LocalDate date, boolean odd) {
        BlockBuilder builder = new BlockBuilder(date)
                .addBlock("reggel", LocalTime.of(5, 0), 12)
                .doubleBlock(7)
                .doubleBlock(8)
                .doubleBlock(10)
                .addShort("3perces-11-pot", 11, 0, 3)
                .singleBlock(12);
        if (odd) {
            builder.singleBlock(13, 30);
        } else {
            builder.singleBlock(13);
        }
        builder.doubleBlock(15)
                .doubleBlock(17)
                .singleBlock(18, 30)
                .addBlock("este", LocalTime.of(19, 48), 9 + 3)
                .doubleBlock(21)
                .addShort("3perces-22-pot", 22, 0, 3);
        return builder.build();
    }

}