dungndrug/fight/Bolt.class: dungndrug/level/Cell.class
	javac dungndrug/fight/Bolt.java

dungndrug/level/Cell.class:
	javac dungndrug/level/Cell.java

dungndrug/level/Block.class:
	javac dungndrug/level/Block.java

dungndrug/user/Hero.class:
	javac dungndrug/user/Hero.java

dungndrug/level/Level.class: dungndrug/level/Level.class dungndrug/user/Hero.class
	javac dungndrug/level/Level.java

dungndrug/level/Board.class: dungndrug/user/Hero.class dungndrug/level/Cell.class
	javac dungndrug/level/Board.java

Game.class: dungndrug/level/Board.class
	javac Game.java

all: Game.class
	echo Done

clean:
	find . -name '*.class' -exec rm {} \;
