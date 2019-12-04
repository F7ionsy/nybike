package cn.tedu.nybike.pojo;
//用于封装数据库表中一行记录得实体类
public class TripcountDO {
		private Integer day;
		private Integer hour;
		private Integer count;
		public TripcountDO() {
			super();
			// TODO Auto-generated constructor stub
		}
		public TripcountDO(Integer day, Integer hour, Integer count) {
			super();
			this.day = day;
			this.hour = hour;
			this.count = count;
		}
		public Integer getDay() {
			return day;
		}
		public void setDay(Integer day) {
			this.day = day;
		}
		public Integer getHour() {
			return hour;
		}
		public void setHour(Integer hour) {
			this.hour = hour;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "TripcountDO [day=" + day + ", hour=" + hour + ", count=" + count + "]";
		}
		
		

}
