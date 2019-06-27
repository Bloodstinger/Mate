package lecture.fifteen.dao;

import lecture.fifteen.db.Storage;
import lecture.fifteen.lib.Dao;
import lecture.fifteen.model.Bet;

import java.util.List;

@Dao
public class BetDaoImpl implements BetDao<Bet> {

    @Override
    public void add(Bet bet) {
        Storage.BETS.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return Storage.BETS;
    }
}
