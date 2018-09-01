def welcome
	puts
    puts "        P  /_\  P                              "
    puts "       /_\_|_|_/_\                             "
    puts "   n_n | ||. .|| | n_n         Welcome to the  "
    puts "   |_|_|nnnn nnnn|_|_|         Guessing Game!  "
    puts "  |' '  |  |_|  |'  ' |                        "
    puts "  |_____| ' _ ' |_____|                        " 
    puts "        \__|_|__/                              "
    puts
    puts "What's your name?"
    yourName = gets.strip
    puts "\n\n\n\n\n\n"
    puts "We'll start the game for you, #{yourName}"
    yourName
end

def lot_number_secret (difficulty)
	case difficulty
		when 1
			maximum = 30
		when 2
			maximum = 60
		when 3 
			maximum = 100
		when 4
			maximum = 150
		else 
			maximum = 200
	end	

	puts "Choosing a number secret between 0 and #{maximum}..."
	drawn = rand(maximum) + 1
	puts "Choosed... how about guessing our secret number today?"
	#return drawn
	drawn
end	

def ask_for_a_number (kicks, attempt, limit_of_attempts)
	puts "\n\n\n"
	#puts "Attempt " + attempt.to_s + " to " + limit_of_attempts.to_s
	puts "Attempt #{attempt} to #{limit_of_attempts}"
	#puts "Kicks until now: " + kicks.to_s
	puts "Kicks until now #{kicks}"
	puts "Enter with a number"
	kick = gets.strip
	#puts "Is it correct? You kicked " + kick
	puts "Is it correct? You kicked #{kick}"
	kick.to_i
end

def check_if_you_got_it_right (secret_number, kick)
	hit = secret_number == kick

	if 	hit
		won
		return true
	end 	
	 
	bigger = secret_number > kick

	if bigger
		puts "The secret number is bigger!"
	else 
		puts "The secret number is smaller!"	
	end
	false
end

def asks_for_trouble
	puts "Whats is the level of difficulty?"
    puts "(1) Very easy (2) Easy (3) Normal (4) Difficult (5) Impossible"
    puts "Choice: "
    difficulty = gets.to_i
end

def won    	
	puts ""
	#puts "              OOOOOOOOOOO               " 
	puts "          OOOOOOOOOOOOOOOOOOO           "
	puts "       OOOOOO  OOOOOOOOO  OOOOOO        "
	puts "     OOOOOO      OOOOO      OOOOOO      "
	puts "   OOOOOOOO  #   OOOOO  #   OOOOOOOO    "
	puts "  OOOOOOOOOO    OOOOOOO    OOOOOOOOOO   "
	puts " OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  "
	puts " OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO  "
	puts " OOOO  OOOOOOOOOOOOOOOOOOOOOOOOO  OOOO  "
	puts "  OOOO  OOOOOOOOOOOOOOOOOOOOOOO  OOOO   "
	puts "   OOOO   OOOOOOOOOOOOOOOOOOOO  OOOO    "
	puts "     OOOOO   OOOOOOOOOOOOOOO   OOOO     "
	puts "       OOOOOO   OOOOOOOOO   OOOOOO      "
	puts "          OOOOOO         OOOOOO         "
	puts "              OOOOOOOOOOOO              "
	puts "                                        "
	puts "                  Hit!                  "
	puts ""
end	

def play(yourName, difficulty)
	secret_number = lot_number_secret difficulty
	limit_of_attempts = 5
	kicks = []

	for attempt in 1..limit_of_attempts
		kick = ask_for_a_number  kicks, attempt, limit_of_attempts	
		#kicks[kicks.size] = kick
		kicks << kick

		if yourName == "Bruno"
		   #won
		   break
		end

		if check_if_you_got_it_right secret_number, kick
			break
		end	

		#break if check_if_you_got_it_right secret_number, kick
	end
end

def do_not_want_to_play?
	puts "Want to play again (Y/N)?"
	want_to_play = gets.strip
	play_again = want_to_play.upcase == "Y"
end

yourName = welcome
difficulty = asks_for_trouble

loop do
	play yourName, difficulty
	#break if !do_not_want_to_play?
	break unless do_not_want_to_play?		
end	


