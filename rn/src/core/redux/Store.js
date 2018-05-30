
import {createStore, applyMiddleware} from 'redux';
import thunkMiddleware from 'redux-thunk';
import rootReducer from './Reducer';

const createStoreWithMiddleware = applyMiddleware(thunkMiddleware)(createStore);

export default function createStoreforMiddle(initialState) {
    const store = createStoreWithMiddleware(rootReducer, initialState);
    return store;
}