package hu.thewhiterabbit.eeprom.handler.service.common;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SerialPortService {

	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

	public List<SerialPort> getAvailablePorts() {
		return Stream.of(SerialPort.getCommPorts())
					 .collect(Collectors.toList());
	}

	public String read(SerialPort serialPort) {
		checkAndOpenPort(serialPort);

		if (serialPort.bytesAvailable() < 1) {
			return null;
		}

		StringBuilder outputData = new StringBuilder();

		while (serialPort.bytesAvailable() > 0) {
			byte[] readBuffer = new byte[serialPort.bytesAvailable()];

			serialPort.readBytes(readBuffer, readBuffer.length);
			outputData.append(new String(readBuffer, DEFAULT_CHARSET));

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return outputData.toString();
	}

	public void write(SerialPort serialPort, String data) {
		checkAndOpenPort(serialPort);

		try (PrintWriter out = new PrintWriter(serialPort.getOutputStream(), true)) {
			out.print(data);
		}
	}

	public void write(SerialPort serialPort, List<String> data) {
		checkAndOpenPort(serialPort);

		try (PrintWriter out = new PrintWriter(serialPort.getOutputStream(), true)) {
			data.forEach(out::println);
		}
	}

	public void writeln(SerialPort serialPort, String data) {
		checkAndOpenPort(serialPort);

		try (PrintWriter out = new PrintWriter(serialPort.getOutputStream(), true)) {
			out.println(data);
		}
	}

	private boolean checkAndOpenPort(SerialPort serialPort) {
		boolean isOpen = serialPort.isOpen();

		if (!isOpen) {
			serialPort.openPort();
		}

		return !isOpen;
	}

}
