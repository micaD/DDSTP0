package ddsTP0;

public enum Ropa {	
	TORSO {
		@Override
		public String getTypeName(){
			return "TORSO";
		}
	},
	PIERNAS {
		@Override
		public String getTypeName() {
			return "PIERNAS";
		}
	},
	PIES {
		@Override
		public String getTypeName() {
			return "PIES";
		}
	},
	ACCESORIOS {
		@Override
		public String getTypeName() {
			return "ACCESORIOS";
		}
	};
	
	public abstract String getTypeName();
}

