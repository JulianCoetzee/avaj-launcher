NAME = simulator

FLAG_C = -d .

FLAG_R = -cp .

SRC_PATH = src/avaj/**/*.java

CLASS_PATH_S = src/avaj/**/*.class

CLASS_PATH_C = src/avaj/simulator/control/*.class

CLASS_PATH_H = src/avaj/simulator/hangar/*.class

CLASS_PATH_W = src/avaj/simulator/weather/*.class

RUN_PATH = src.avaj.simulator.Simulator

TEST_PATH = specs\ \&\ tests/tests/

all: classes standard

classes:
	@javac $(FLAG_C) $(SRC_PATH)
	@echo "compiled classes"

standard:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)standard.txt
	@echo "simulation created"

short:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)short.txt
	@echo "simulation created"
	
nocycle:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)nocycle.txt

cycleerr:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)invalidcycle.txt

bicycle:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)aircraftinvalid.txt

formaterr1:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)extracoords.txt

formaterr2:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)invalidcoords.txt

formaterr3:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)missingcoords.txt
	
formaterr4:
	@java $(FLAG_R) $(RUN_PATH) $(TEST_PATH)nonintcoords.txt

clean:
	@rm -rf $(CLASS_PATH_S)
	@rm -rf $(CLASS_PATH_C)
	@rm -rf $(CLASS_PATH_H)
	@rm -rf $(CLASS_PATH_W)
	@echo "classes deleted"

fclean: clean
	@rm -rf simulation.txt
	@echo "simulation deleted"

re: fclean all

.PHONY: all clean fclean re