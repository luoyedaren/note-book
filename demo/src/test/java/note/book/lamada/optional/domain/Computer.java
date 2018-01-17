package note.book.lamada.optional.domain;

import lombok.Data;

import java.util.Optional;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 */
@Data
public class Computer {
	private String name;
	private String version;
	private long price;

	private Cpu cpu;
	private SoundCard soundCard;

	private Optional<Cpu> cpuOptional;
	private Optional<SoundCard> soundCardOptional;
}
