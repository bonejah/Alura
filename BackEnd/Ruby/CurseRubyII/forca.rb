require_relative 'ui'
require_relative 'rank'

# def count_word_or_letter (text, letter)
# 	total_found = 0

# 	for character in text.chars
# 		if character == letter
# 			total_found += 1
# 		end
# 	end	

# 	total_found	
# end 	

def choose_secret_word
	warns_chossing_word
	text = File.read("dictionary.txt")
	all_the_words = text.split "\n"
	number_selected = rand(all_the_words.size)
	secret_word = all_the_words[number_selected].downcase
	warns_the_chosen_word secret_word
	secret_word
end	

def choose_secret_word_without_consuming_too_much_memory
	warns_chossing_word
	file = File.new("dictionary.txt")
	quantity_of_words = file.gets.to_i
	number_selected = rand(quantity_of_words)

	for line in 1..(number_selected - 1)
		file.gets
	end

	secret_word = file.gets.strip.downcase
	file.close
	warns_the_chosen_word secret_word
	secret_word
end	

def masked_word (kicks, secret_word)
	mask = ""

	for letter in secret_word.chars
		if kicks.include? letter
			mask << letter
		else
			mask << "_"	
		end	
	end	

	mask
end

def call_for_a_kick (kicks, errors, mask)
	header_a_kick kicks, errors, mask

	loop do
		kick = ask_for_a_kick

		if kicks.include? kick
			warn_kick_made kick
		else 
			return kick	
		end
	end	 
end	

def play (name)
	secret_word = choose_secret_word	
	#secret_word = choose_secret_word_without_consuming_too_much_memory	

	errors = 0
	kicks = []
	points_until_now = 0

	while errors < 5
		mask = masked_word kicks, secret_word
		kick = call_for_a_kick kicks, errors, mask
		
		kicks << kick

		kick_a_letter = kick.size == 1

		if kick_a_letter
			sought_letter = kick[0]
			#total_found = count_word_or_letter secret_word, sought_letter
			total_found = secret_word.count sought_letter

			if total_found == 0		
				warn_letter_not_found 		
				errors +=1
			else
				warn_letter_found total_found
			end	
		else
			hit = kick == secret_word
			if hit
				warn_you_hit_the_word
				points_until_now += 100
				break
			else
				warn_you_missed
				points_until_now -= 30
				errors += 1
			end
		end	
	end	

	warn_points_until_now points_until_now
	points_until_now
end

def hangman
	yourName = welcome
	total_points = 0
	warn_current_champion read_hank

	loop do
		total_points += play yourName
		warn_total_points total_points

		if read_hank[1].to_i < total_points
			save_rank yourName, total_points
		end

		if do_not_want_to_play?
			break
		end
	end
end









