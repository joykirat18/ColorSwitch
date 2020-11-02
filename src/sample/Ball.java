package sample;

public class Ball {
	private String colour;
	private int jumpSize;
	private int[] position;
	private int radius;

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;


		public int getJumpSize () {
			return jumpSize;
		}

		public void setJumpSize ( int jumpSize){
			this.jumpSize = jumpSize;
		}

		public int[] getPosition () {
			return position;
		}

		public void setPosition ( int[] position){
			this.position = position;
		}

		public int getRadius () {
			return radius;
		}

		public void setRadius ( int radius){
			this.radius = radius;
		}

		/**
		 * Getter Setter for X and Y position for easy working
		 */
		public int getPosX(){
			return this.getPosition()[0];
		}

		public int getPosY(){
			return this.getPosition()[1];
		}

		public void setPosX(int x){
			this.setPosition(new int[x, this.getPosY()]);
		}

		public void setPosY(int y){
			this.setPosition(new int[this.getPosX(), y]);
		}

		/**
		 * Makes the ball jump according to the jumpSize of the ball
		 */
		public void jump(){
			this.setPosY(this.getPosY() + jumpSize);
		}

		/**
		 * Constantly decreases the height of the ball by some n amount
		 */
		public void decreaseHeight(int n){
			this.setPosY(this.getPosY() - n);
		}
	}
