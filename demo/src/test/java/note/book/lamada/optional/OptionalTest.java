package note.book.lamada.optional;

import note.book.lamada.optional.domain.Computer;
import note.book.lamada.optional.domain.Cpu;
import org.junit.Test;

import java.util.Optional;

/**
 * project: note-book
 * Created by chenghai on 2018/1/17. - 星期三
 */
public class OptionalTest {

	@Test
	public void testOne() throws Exception {
		Computer computer = new Computer();
		Cpu cpu = new Cpu();
		cpu.setName("i3");
		computer.setCpu(cpu);
		String name = computer.getCpu().getName();
		System.out.println(name);
	}

	@Test
	public void testTow() throws Exception {
		Computer computer = new Computer();
		Cpu cpu = new Cpu();
		cpu.setName("i3");
		computer.setCpu(cpu);
		Optional<Computer> computerOptional = Optional.of(new Computer());
	}
}
