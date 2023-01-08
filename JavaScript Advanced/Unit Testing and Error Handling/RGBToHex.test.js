const {assert} = require('chai');
const {rgbToHexColor} = require('./RGBToHex');

describe('RGBToHex', () => {
    it('should return #FFFFF if the input is 255, 255, 255', () => {
        assert.equal(rgbToHexColor(255, 255, 255), '#FFFFFF');
    });
    it('should return #000000 if the input is 0, 0, 0', () => {
        assert.equal(rgbToHexColor(0, 0, 0), '#000000');
    });
    it('should return #FF0000 if the input is 0, 0, 0', () => {
        assert.equal(rgbToHexColor(255, 0, 0), '#FF0000');
    });
    it('should return undefined if the input is 256, 255, 255', () => {     
        assert.isUndefined(rgbToHexColor(256, 255, 255));
    });
    it('should return undefined if the input is 255, 256, 255', () => {            
        assert.isUndefined(rgbToHexColor(255, 256, 255));
    });
    it('should return undefined if the input is 255, 255, 256', () => {            
        assert.isUndefined(rgbToHexColor(255, 255, 256));
    });
    it('should return undefined if the input is 255, -5, 255', () => {            
        assert.isUndefined(rgbToHexColor(255, -5, 255));
    });
    it('should return undefined if the input is 255, 255', () => {            
        assert.isUndefined(rgbToHexColor(255, 255));
    });
    it('should return undefined if the input is \'5\',255, 255', () => {            
        assert.isUndefined(rgbToHexColor('5',255, 255));
    });
    it('should return undefined if the input is 5, \'z\', 255', () => {            
        assert.isUndefined(rgbToHexColor(5,'z', 255));
    });
    it('should return undefined if the input is 5, 255, , \'z\'', () => {            
        assert.isUndefined(rgbToHexColor(5, 255, 'z'));
    });
});