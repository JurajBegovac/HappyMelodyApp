package tomislav.kurtovic.com.happymelodyapp.db;

public enum School {
	MARKUSEVEC,
	GRACANI,
	MIOC,
	SREBRNJAK;

	public String getViewPresentation() {
		switch (this) {
			case MARKUSEVEC:
				return "Markusevec";
			case GRACANI:
				return "Gracani";
			case MIOC:
				return "Mioc";
			case SREBRNJAK:
				return "Srebrnjak";
		}
		throw new IllegalStateException("Wrong school");
	}
}