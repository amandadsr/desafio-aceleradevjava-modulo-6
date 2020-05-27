package challenge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();

		if(quotes.size() == 0) {
			return null;
		}
		
		//Random rnd = ThreadLocalRandom.current();
		//int num = rnd.nextInt(quotes.size()-1);// 
		int num = (int) Math.random() * quotes.size();
		
		return quotes.get(num);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);

		if(quotes.size() == 0) {
			return null;
		}
		
		//Random rnd = ThreadLocalRandom.current();
		//int num = rnd.nextInt(quotes.size()-1);
		int num = (int) Math.random() * quotes.size();
		
		return quotes.get(num);
	}

}
