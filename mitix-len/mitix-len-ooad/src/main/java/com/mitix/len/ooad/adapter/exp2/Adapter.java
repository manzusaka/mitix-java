package com.mitix.len.ooad.adapter.exp2;

/**
 * 创建于:2016年10月4日<br>
 * GPL 2016 a code farmer<br>
 * TODO
 *
 * @author infoconsole
 * @version TODO
 */
public class Adapter implements AdTar4get {
    private IAdaptee iAdaptee;

    public Adapter(IAdaptee iAdaptee) {
        super();
        this.iAdaptee = iAdaptee;
    }

    /*
     * (non-Javadoc)
     *
     * @see Target#sampleOperation2()
     */
    @Override
    public void sampleOperation2() {
        // TODO Auto-generated method stub
        iAdaptee.sampleOperation1();
    }

}
