JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		PlayerStats.java \
		PlayerName.java \
		Position.java \
		Player.java \
		PlayerOverall.java \
		Team.java \
		TeamName.java \
		TeamStats.java \
        Game.java \
        League.java \
        LeagueTable.java \
		Schedule.java \
		Season.java \
		Fm.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
	
