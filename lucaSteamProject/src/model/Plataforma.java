package model;

import com.google.gson.annotations.SerializedName;

public class Plataforma {

	public enum plataforma {
		PS2, X360, PS3, WII, DS, PS, GBA, PS4, PSP, PC, XB, GC, @SerializedName("3DS")
		_3DS, N64, PSV, SAT, SNES, XOne, WiiU, GEN, DC, NES, NG, WS, SCD, TG16, 
		@SerializedName("2600")_2600, 
		@SerializedName("3DO")_3DO,
		GG, PCFX, OTRA
	}

}
