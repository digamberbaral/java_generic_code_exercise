// MongoDB Playground
// Use Ctrl+Space inside a snippet or a string literal to trigger completions.

// The current database to use.
use('bm_orderservice');
db.getCollection('productorder').findOne({ externalId: 'QU250527_1ad23adb' });
