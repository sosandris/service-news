package hu.tilos.radio.backend.scheduling;

import hu.tilos.radio.backend.NewsBlock;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BlockBuilder {
    LocalDate date;
    List<NewsBlock> result;

    public BlockBuilder(LocalDate date) {
        this.date = date;
        this.result = new ArrayList<>();
    }

    public List<NewsBlock> build() {
        return result;
    }

    public BlockBuilder addShort(String name, int hour, int minute, int duration) {
        addShort(name, hour, minute, 0, duration);
        return this;
    }

    public BlockBuilder addShort(String name, int hour, int minute, int duration, String description) {
        addShort(name, hour, minute, 0, duration);
        return this;
    }

    public BlockBuilder addShort(String name, int hour, int minute, int second, int duration) {
        result.add(new NewsBlock(name, date.atTime(hour, minute, second), duration * 60)
                .setWithSeparatorSignal(false)
                .setBackgroundPath("bangkok.wav")
                .setSignalType("short"));
        return this;
    }


    protected BlockBuilder singleBlock(int hour, int min) {
        addShort("3perces-" + hour, hour, 28, 30, 3);
        return this;
    }

    protected BlockBuilder singleBlock(int hour) {
        addShort("3perces-" + hour, hour, 0, 3);
        return this;
    }

    protected BlockBuilder doubleBlock(int hour) {
        addShort("3perces-" + (hour - 1) + "-" + hour, hour - 1, 57, 6);
        addShort("3perces-" + (hour - 1) + "-" + hour + "-havolt", hour, 0, 3);
        return this;
    }

    protected BlockBuilder singleBlockPre(int hour) {
        addShort("3perces-" + (hour - 1), hour - 1, 57, 3);
        return this;

    }

    public BlockBuilder addShort(String name, LocalTime time, int duration) {
        addShort(name, time.getHour(), time.getMinute(), duration);
        return this;
    }

    public BlockBuilder addBlock(String name, LocalTime time, int durationMinute) {
        result.add(new NewsBlock(name, date.atTime(time), durationMinute * 60));
        return this;
    }

}