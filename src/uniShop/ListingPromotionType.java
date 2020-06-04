package uniShop;

public enum ListingPromotionType {
	
	NOT_PROMOTED{
		@Override
		public String toString() {
			return "";
		}
	},
	PROMOTION_LEVEL1{
		@Override
		public String toString() {
			return "Tier #1";
		}
	},
	PROMOTION_LEVEL2{
		@Override
		public String toString() {
			return "Tier #2";
		}
	}

}
