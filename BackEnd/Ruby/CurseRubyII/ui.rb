def welcome
	puts "/******************************/"
	puts "/ Welcome to the Game HangMan */"
	puts "/******************************/"
	puts "What's your name?"
	name = gets.strip
	puts "\n\n\n\n\n\n"
	puts "We'll start the game for you #{name}"
	name
end

def draw_hangman(errors)
    head = "   "
    body = " "
    legs = "   "
    arms = "   "
    if errors >= 1
        head = "(_)"
    end
    if errors >= 2
        arms = " | "
        body = "| |"
    end
    if errors >= 3
        arms = "\\|/"
    end
    if errors >= 4
        legs = "/ \\"
    end

    puts "  _______        "
    puts " |/      |       "
    puts " |      #{head}  "
    puts " |      #{arms}  "
    puts " |      #{body}  "
    puts " |      #{legs}  "
    puts " |               "
    puts "_|___            "
    puts

end

def header_a_kick (kicks, errors, mask)
	puts "\n\n\n\n\n"
	draw_hangman errors
	puts "Secret word: #{mask}"
	puts "Erros until now #{errors}"
	puts "Kicks until now #{kicks}"
end

def ask_for_a_kick
	puts "Enter a letter or a word"
	kick = gets.strip.downcase
 	puts "It's correct? You kick #{kick}"
 	kick
end

def do_not_want_to_play?
	puts "Want to play again (Y/N)?"
	want_to_play = gets.strip
	play_again = want_to_play.upcase == "N"
end

def warn_kick_made (kick)
	puts "You already kicked #{kick}."
end

def warn_letter_not_found
	puts "Sought letter not found."
end

def warn_letter_found (total_found)
	puts "Sought letter #{total_found} time(s)."
end

def warn_you_hit_the_word
	puts "Congratulations, You win!"
	puts
  puts "       ___________      "
  puts "      '._==_==_=_.'     "
  puts "      .-\\:      /-.    "
  puts "     | (|:.     |) |    "
  puts "      '-|:.     |-'     "
  puts "        \\::.    /      "
  puts "         '::. .'        "
  puts "           ) (          "
  puts "         _.' '._        "
  puts "        '-------'       "
  puts
end

def warn_you_missed
	puts "What a pity..missed"
end

def warn_points_until_now (points_until_now)
	puts "You win #{points_until_now} points."
end

def warns_chossing_word
	puts "Choosing a secret word...."
end

def warns_the_chosen_word (secret_word)
	puts "Secret word whit #{secret_word.size} letters... good luck!"
end

def warn_total_points (total_points)
	puts "Your score: #{total_points} points."
end

def warn_current_champion (data)
	puts "Our current champion is #{data[0]} with #{data[1]} points."
end



